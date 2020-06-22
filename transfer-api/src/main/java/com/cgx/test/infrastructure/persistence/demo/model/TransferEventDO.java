package com.cgx.test.infrastructure.persistence.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class TransferEventDO {

    private Long id;

    private String transactionNo;

    private Long selfUserId;

    private Long oppositeUserId;

    private Long amount;

    private Date gmtCreated;

    private Date gmtModified;

}