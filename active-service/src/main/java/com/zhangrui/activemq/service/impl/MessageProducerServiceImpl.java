package com.zhangrui.activemq.service.impl;

import com.zhangrui.activemq.service.IMessageProducerService;
import org.apache.activemq.broker.region.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerServiceImpl implements IMessageProducerService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public void send(String name, String message) {
        jmsTemplate.convertAndSend(name,message);
    }
}
