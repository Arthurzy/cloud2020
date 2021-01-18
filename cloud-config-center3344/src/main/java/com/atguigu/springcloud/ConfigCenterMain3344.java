package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author YongZhang
 * @version 1.0
 * @description: ConfigCenterMain3344
 * @create Jan 18, 2021 4:05:33 PM
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigCenterMain3344 {
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }

}
