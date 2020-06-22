package com.cgx.test.domain.model;

import lombok.Getter;

@Getter
public enum AccountStateEnum {

    NORMAL(0),

    DISABLE(1);

    private int stateCode;

    AccountStateEnum(int stateCode) {
        this.stateCode = stateCode;
    }

}
