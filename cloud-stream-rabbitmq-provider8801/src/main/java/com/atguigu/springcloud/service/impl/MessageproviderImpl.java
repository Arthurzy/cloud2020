package com.atguigu.springcloud.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.atguigu.springcloud.service.IMessageProvider;

/**
 * @author YongZhang
 * @version 1.0
 * @description: MessageproviderImpl
 * @create Feb 5, 2021 11:43:46 AM
 */
@EnableBinding(Source.class ) // 定义消息的推送管道
public class MessageproviderImpl implements IMessageProvider{

    @Resource
    private MessageChannel output; // 消息发送管道
    
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: " + serial);
        return "*****serial: " + serial;
    }

}


