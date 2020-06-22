package com.cgx.test.interfaces.activity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.Serializable;

@Data
public class TransferCommand implements Serializable {

    private static final long serialVersionUID = 5198859892076164813L;

    @ApiModelProperty(value = "token", example = "1234567")
    private String token;

    @ApiModelProperty(value = "交易单号", example = "100_20200621001")
    private String transactionNo;

    @ApiModelProperty(value = "扣款方", example = "1")
    private Long selfUserId;

    @ApiModelProperty(value = "转账金额", example = "100")
    private Long amount;

    @ApiModelProperty(value = "收款方", example = "2")
    private Long oppositeUserId;

    public void assignSelfUserId(Long userId) {
        this.selfUserId = userId;
    }

    /**
     * TODO 可用JSR-303来做参数校验
     */
    public void check() {
        Assert.notNull(oppositeUserId, "参数缺失");
        Assert.isTrue(StringUtils.hasText(transactionNo), "参数非法");
    }

}
