package com.cgx.test.domain.repository;

import com.cgx.test.domain.model.AssetAccount;

public interface AccountRepository {

    /**
     * 查找
     */
    AssetAccount find(Long accountId);

    /**
     * 更新
     */
    void save(AssetAccount account);

}
