package com.atguigu.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author YongZhang
 * @version 1.0
 * @description: OrderConsulController
 * @create Jan 7, 2021 3:58:41 PM
 */
@Slf4j
@RestController
public class OrderConsulController {

    public static final String INVOKE_URL ="http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return result;
    }
}


