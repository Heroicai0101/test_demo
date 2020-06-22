package com.cgx.test.domain.model;

import lombok.Getter;

@Getter
public enum TransferFlowStateEnum {

    TODO(0, "待处理"),

    DONE(1, "已完成");

    private int stateCode;

    private String stateDesc;

    TransferFlowStateEnum(int stateCode, String stateDesc) {
        this.stateCode = stateCode;
        this.stateDesc = stateDesc;
    }

}
