package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author YongZhang
 * @version 1.0
 * @description: PaymentFallbackService
 * @create Jan 14, 2021 11:07:57 AM
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fall back paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentFallbackService fall back paymentInfo_Timeout";
    }

}


