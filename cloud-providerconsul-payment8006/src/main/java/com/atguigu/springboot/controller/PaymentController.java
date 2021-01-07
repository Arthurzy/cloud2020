package com.atguigu.springboot.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author YongZhang
 * @version 1.0
 * @description: PaymentController
 * @create Jan 7, 2021 3:37:44 PM
 */

@Slf4j
@RestController
public class PaymentController {
    
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return "spring cloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}


