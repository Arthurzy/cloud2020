package com.atguigu.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Arthurzy
 * @version 1.0
 * @description: TODO
 * @create 2021/1/6 22:59
 */
@Slf4j
@EnableDiscoveryClient //该注解用于想使用consul或者zookeeper作为注册中心事注册服务
@SpringBootApplication
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
