package com.cgx.test.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AssetAccount {

    private Long accountId;

    private Long balance;

    private int version;

    private int state;

    public void transferTo(long amount) {
        Assert.isTrue(state == AccountStateEnum.NORMAL.getStateCode(), "账户状态异常");
        Assert.isTrue(balance >= amount, "账户余额不足");

        this.balance = balance - amount;
        updateVersion();
    }

    public void transferFrom(long amount) {
        Assert.isTrue(state == AccountStateEnum.NORMAL.getStateCode(), "账户状态异常");
        Assert.isTrue(amount > 0, "转入金额数值非法");

        this.balance = balance + amount;
        updateVersion();
    }

    private void updateVersion() {
        this.version += 1;
    }

}
