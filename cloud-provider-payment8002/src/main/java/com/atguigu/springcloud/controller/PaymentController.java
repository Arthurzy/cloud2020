package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Arthurzy
 * @version 1.0
 * @description: TODO
 * @create 2021/1/4 22:47
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("******** 插入结果:" + result);
        if (result > 0){
            return new CommonResult<Integer>(200, "插入数据库成功, serverPort: " + serverPort, result);
        }else {
            return new CommonResult<Integer>(444, "插入数据库失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******** 查询结果:" + payment);
        if (payment != null){
            return new CommonResult<Payment>(200, "查询成功, serverPort: " + serverPort, payment);
        }else {
            return new CommonResult<Payment>(444, "没有对应记录，查询ID: " + id);
        }
    }
}
