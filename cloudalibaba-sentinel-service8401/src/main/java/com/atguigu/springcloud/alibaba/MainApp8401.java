package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author YongZhang
 * @version 1.0
 * @description: MainApp8401
 * @create Mar 16, 2021 4:59:20 PM
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MainApp8401 {
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApp8401.class, args);
    }
}


