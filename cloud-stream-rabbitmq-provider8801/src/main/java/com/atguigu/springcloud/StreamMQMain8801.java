package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author YongZhang
 * @version 1.0
 * @description: StreamMQMain8801
 * @create Feb 5, 2021 11:33:05 AM
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8801 {
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(StreamMQMain8801.class, args);
    } 
}
