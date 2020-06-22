package com.cgx.test.application.consumer;

import com.cgx.test.domain.model.AssetAccount;
import com.cgx.test.domain.model.TransferEvent;
import com.cgx.test.domain.repository.AccountRepository;
import com.cgx.test.infrastructure.persistence.demo.mapper.TransferEventMapper;
import com.cgx.test.infrastructure.persistence.demo.model.TransferEventDOExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class TransferMsgProcess {

    @Resource
    private AccountRepository accountRepository;

    @Resource
    private TransferEventMapper transferEventMapper;

    @Transactional(rollbackFor = Exception.class, timeout = 3)
    public void increaseMoney(TransferEvent event) {
        // 收款
        AssetAccount account = accountRepository.find(event.getOppositeUserId());
        account.transferFrom(event.getAmount());
        accountRepository.save(account);

        // 删除消费表的消息
        TransferEventDOExample example = new TransferEventDOExample();
        example.createCriteria()
               .andTransactionNoEqualTo(event.getTransactionNo());
        transferEventMapper.deleteByExample(example);
    }

}
