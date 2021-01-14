package com.atguigu.springcloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.hutool.core.util.IdUtil;

/**
 * @author YongZhang
 * @version 1.0
 * @description: PaymentService
 * @create Jan 12, 2021 2:38:39 PM
 */
@Service
public class PaymentService {
    
    //==============a.服务降级
    public String paymentInfo_OK(Integer id) {
        return "线程池 " + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id;
    }
    
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", 
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
        }
    )
    public String paymentInfo_Timeout(Integer id) {
        
        int timeNum = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return "线程池 " + Thread.currentThread().getName() + " paymentInfo_Timeout, id: " + id;
    }
    
    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池 " + Thread.currentThread().getName() + " paymentInfo_TimeoutHandler, id: " + id;
    }
    
    //==================b.服务熔断
    
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_Fallback", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间拆给你扣期
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少跳闸
    })
    public String  paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("**********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        
        return Thread.currentThread().getName() + "调用成功， 流水号： " + serialNumber;
    }
    
    public String paymentCircuitBreaker_Fallback(@PathVariable("id") Integer id) {
        return "id不能为负数，请伤后再试 id： " + id;
    }
}


