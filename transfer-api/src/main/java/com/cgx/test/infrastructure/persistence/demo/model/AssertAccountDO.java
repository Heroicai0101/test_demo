package com.cgx.test.infrastructure.persistence.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class AssertAccountDO {

    private Long id;

    private Long accountId;

    private Long balance;

    private Byte state;

    private Integer version;

    private Date gmtCreated;

    private Date gmtModified;

}