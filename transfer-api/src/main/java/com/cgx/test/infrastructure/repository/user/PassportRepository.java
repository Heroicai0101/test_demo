package com.cgx.test.infrastructure.repository.user;

import org.springframework.stereotype.Repository;

@Repository
public class PassportRepository {

    /**
     * TODO 替换为真实的用户认证服务
     */
    public UserInfo findUserByToken(String token) {
        UserInfo userInfo = new UserInfo();
        // 这里先写死为1号用户
        userInfo.setUserId(1L);
        userInfo.setUserName("cgx");
        return userInfo;
    }

}
