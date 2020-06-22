package com.cgx.test.application.service;

import com.cgx.test.common.exception.CustomException;
import com.cgx.test.domain.service.TransferService;
import com.cgx.test.domain.shard.BizStatusCode;
import com.cgx.test.interfaces.activity.dto.TransferCommand;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class TransferAppService {

    private static final String LOCK_NAMESPACE = "transfer_lock:";

    @Resource
    private TransferService transferService;

    @Resource
    private RedissonClient redissonClient;

    /**
     * 转账处理流程
     */
    public String startTransfer(TransferCommand command) {
        RLock rLock = redissonClient.getLock(LOCK_NAMESPACE + command.getTransactionNo());

        try {
            // 采用分布式锁进行并发控制
            boolean acquiredLock = rLock.tryLock(300, 900, TimeUnit.MILLISECONDS);
            if (!acquiredLock) {
                // 未获得锁
                return "系统正在处理中，请勿频繁操作";
            }

            transferService.transferTo(command.getSelfUserId(), command.getOppositeUserId(), command.getAmount(),
                    command.getTransactionNo());
            return "转账申请提交成功";
        } catch (Exception e) {
            throw new CustomException(BizStatusCode.TRANSFER_SUBMIT_FAILED, e);
        } finally {
            rLock.unlock();
        }
    }

}
