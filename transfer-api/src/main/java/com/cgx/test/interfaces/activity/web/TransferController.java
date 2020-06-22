package com.cgx.test.interfaces.activity.web;

import com.cgx.test.application.service.TransferAppService;
import com.cgx.test.infrastructure.repository.user.PassportRepository;
import com.cgx.test.infrastructure.repository.user.UserInfo;
import com.cgx.test.interfaces.activity.dto.TransferCommand;
import com.cgx.test.module.response.Response;
import com.cgx.test.module.response.ResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "转账接口")
@RestController
@RequestMapping("/api/v1")
public class TransferController {

    @Resource
    private TransferAppService transferAppService;

    @Resource
    private PassportRepository passportRepository;

    @ApiOperation(value = "转账")
    @PostMapping("/transfer")
    public Response<String> changeActivityStatus(@RequestBody TransferCommand command) {
        // 入参校验
        command.check();

        // 用户校验
        UserInfo user = passportRepository.findUserByToken(command.getToken());
        Assert.notNull(user, "登陆信息已过期");

        command.assignSelfUserId(user.getUserId());
        String res = transferAppService.startTransfer(command);
        return ResponseBuilder.ok(res);
    }

}
