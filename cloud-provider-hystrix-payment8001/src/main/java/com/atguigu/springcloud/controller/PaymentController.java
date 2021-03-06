package com.atguigu.springcloud.controller;

import static org.mockito.Mockito.RETURNS_SMART_NULLS;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author YongZhang
 * @version 1.0
 * @description: PaymentController
 * @create Jan 12, 2021 2:46:49 PM
 */
@Slf4j
@RestController
public class PaymentController {
    
    @Resource
    private PaymentService paymentService;
    
    @Value("${server.port")
    private String serverPort;
    
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("result = " + result);
        return result;
    }
    
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("result = " + result);
        return result;
    }
    
    // ======= b.服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("**********result: " + result);
        return result;
    }
}


