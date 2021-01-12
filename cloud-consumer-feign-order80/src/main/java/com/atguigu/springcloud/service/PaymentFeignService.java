package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

/**
 * @author YongZhang
 * @version 1.0
 * @description: PaymentFeignService
 * @create Jan 11, 2021 2:37:50 PM
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);
    
    @GetMapping("/payment/lb")
    public String getPaymentPort();

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}


