package com.atguigu.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.service.IMessageProvider;

/**
 * @author YongZhang
 * @version 1.0
 * @description: SendMessageController
 * @create Mar 8, 2021 5:11:57 PM
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider iMessageProvider;
    
    @GetMapping("/sendMessage")
    public String sendMessage() {
       return iMessageProvider.send();
    }
}


