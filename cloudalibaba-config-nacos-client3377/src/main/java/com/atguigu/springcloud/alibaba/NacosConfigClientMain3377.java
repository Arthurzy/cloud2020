package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author YongZhang
 * @version 1.0
 * @description: NacosConfigClientMain3377
 * @create Mar 15, 2021 11:05:22 AM
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientMain3377 {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(NacosConfigClientMain3377.class, args);
    }
    
}


