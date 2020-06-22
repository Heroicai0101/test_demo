package com.cgx.test.domain.shard;

import com.cgx.test.common.enums.Status;

/**
 * 应用自定义异常
 */
public enum BizStatusCode implements Status {

    TRANSFER_SUBMIT_FAILED(20001, "转账申请提交失败，请稍后重试"),
    REPEATED_TRANSFER_REQUEST(20002, "转账请求处理中，请勿重复操作");

    private final int status;

    private final String msg;

    BizStatusCode(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String getCode() {
        return this.name();
    }

}
