package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.atguigu.myrule.MyRule;

/**
 * @author Arthurzy
 * @version 1.0
 * @description: TODO
 * @create 2021/1/5 23:13
 */
@EnableEurekaClient
@SpringBootApplication
//@LoadBalancerClient(value = "myRule", configuration = MyRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
