package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author YongZhang
 * @version 1.0
 * @description: OrderNacosMain83
 * @create Mar 15, 2021 2:14:34 PM
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain83 {
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(OrderNacosMain83.class, args);
    }

}
