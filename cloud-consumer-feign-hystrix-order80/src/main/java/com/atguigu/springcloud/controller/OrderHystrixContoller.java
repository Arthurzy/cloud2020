package com.atguigu.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * @author YongZhang
 * @version 1.0
 * @description: PaymentHystrixContoller
 * @create Jan 13, 2021 3:38:45 PM
 */
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixContoller {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);

        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutFallbackMethod", 
//        commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500") 
//        }
//    )
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        
        int age = 10/0;
        String result = paymentHystrixService.paymentInfo_Timeout(id);

        return result;
    }
    
    public String paymentInfo_TimeoutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80，对方支付系统繁忙";
    }
    
    //a.下面的是全局fallback 方法
    public String payment_Global_FallbackMethod() {
        return "全局异常处理，请稍后再试";
    }
}
