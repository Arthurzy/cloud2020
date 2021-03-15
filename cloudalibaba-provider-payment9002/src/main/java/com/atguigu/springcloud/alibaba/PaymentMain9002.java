package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author YongZhang
 * @version 1.0
 * @description: PaymentMain9001
 * @create Mar 12, 2021 3:03:01 PM
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9002 {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PaymentMain9002.class, args);
    }

}


