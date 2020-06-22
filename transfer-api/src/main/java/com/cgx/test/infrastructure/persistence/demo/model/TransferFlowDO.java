package com.cgx.test.infrastructure.persistence.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TransferFlowDO {

    private Long id;

    private String transactionNo;

    private Long selfUserId;

    private Long oppositeUserId;

    private Long amount;

    private Byte state;

    private Date gmtCreated;

    private Date gmtModified;

}