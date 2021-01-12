package com.atguigu.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;

/**
 * @author YongZhang
 * @version 1.0
 * @description: OrderFeignController
 * @create Jan 11, 2021 2:56:56 PM
 */

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;
    
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        return paymentFeignService.getPaymentById(id);        
    }
    
    @GetMapping("/consumer/payment/port")
    public String getPaymentPort() {
        return "port is " + paymentFeignService.getPaymentPort();
    };
    
    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfiegn-ribbon,客户端默认等待一秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}


