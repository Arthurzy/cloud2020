package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YongZhang
 * @version 1.0
 * @description: PaymentController
 * @create Mar 12, 2021 3:05:35 PM
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    
    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "Hello Nacos Discovery " + serverPort + "\t id = " + id;
    }
}


