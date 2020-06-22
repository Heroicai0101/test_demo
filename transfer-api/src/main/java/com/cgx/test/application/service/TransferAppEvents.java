package com.cgx.test.application.service;

import com.cgx.test.domain.model.TransferEvent;

public interface TransferAppEvents {

    default void onMoneyDecreased(TransferEvent event) {
    }

}
