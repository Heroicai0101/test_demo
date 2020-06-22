package com.cgx.test.infrastructure.repository.account;

import com.cgx.test.domain.model.AssetAccount;
import com.cgx.test.domain.repository.AccountRepository;
import com.cgx.test.infrastructure.persistence.demo.mapper.AssertAccountMapper;
import com.cgx.test.infrastructure.persistence.demo.model.AssertAccountDO;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Resource
    private AssertAccountMapper assertAccountMapper;

    @Override
    public AssetAccount find(Long accountId) {
        AssertAccountDO accountDO = assertAccountMapper.selectByAccountId(accountId);

        AssetAccount capitalAccount = new AssetAccount();
        capitalAccount.setAccountId(accountDO.getAccountId());
        capitalAccount.setBalance(accountDO.getBalance());
        capitalAccount.setVersion(accountDO.getVersion());
        capitalAccount.setState(accountDO.getState());
        return capitalAccount;
    }

    @Override
    public void save(AssetAccount account) {
        AssertAccountDO accountDO = new AssertAccountDO();
        accountDO.setAccountId(account.getAccountId());
        accountDO.setBalance(account.getBalance());
        accountDO.setVersion(account.getVersion());
        accountDO.setState((byte) account.getState());

        int affectedRows = assertAccountMapper.updateByAccountId(accountDO);
        Assert.isTrue(affectedRows == 1, "转账失败，请稍后再试");
    }

}
