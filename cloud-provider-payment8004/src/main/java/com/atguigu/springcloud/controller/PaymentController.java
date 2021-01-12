package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Arthurzy
 * @version 1.0
 * @description: TODO
 * @create 2021/1/6 23:02
 */
@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public String paymentzk(){
        return "spring cloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}