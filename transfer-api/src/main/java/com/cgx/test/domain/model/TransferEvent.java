package com.cgx.test.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferEvent implements Serializable {

    private static final long serialVersionUID = 6520525907106509212L;

    private String transactionNo;

    private Long selfUserId;

    private Long oppositeUserId;

    private Long amount;

}