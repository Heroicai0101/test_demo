package com.cgx.test.application.service.impl;

import com.cgx.test.application.service.TransferAppEvents;
import com.cgx.test.domain.model.TransferEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TransferAppEventsImpl implements TransferAppEvents {

    @Resource
    private ApplicationEventPublisher eventPublisher;

    @Override
    public void onMoneyDecreased(TransferEvent event) {
        eventPublisher.publishEvent(event);
    }

}
