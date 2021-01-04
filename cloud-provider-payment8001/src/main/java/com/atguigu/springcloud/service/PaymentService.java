package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Arthurzy
 * @version 1.0
 * @description: TODO
 * @create 2021/1/4 22:40
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
