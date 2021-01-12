package com.atguigu.springcloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

/**
 * @author YongZhang
 * @version 1.0
 * @description: PaymentService
 * @create Jan 12, 2021 2:38:39 PM
 */
@Service
public class PaymentService {
    

    public String paymentInfo_OK(Integer id) {
        return "线程池 " + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id;
    }
    
    
    public String paymentInfo_Timeout(Integer id) {
        
        int timeNum = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return "线程池 " + Thread.currentThread().getName() + " paymentInfo_Timeout, id: " + id;
    }
}

