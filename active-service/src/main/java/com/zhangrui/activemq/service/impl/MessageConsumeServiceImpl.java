package com.zhangrui.activemq.service.impl;

import com.zhangrui.activemq.service.IMessageConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumeServiceImpl implements IMessageConsumeService {

    @Autowired JmsTemplate jmsTemplate;

    @Override
    public Object consume(String name) {
        return jmsTemplate.receiveAndConvert(name);
    }
}
