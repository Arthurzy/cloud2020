package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author YongZhang
 * @version 1.0
 * @description: ConfigClientMain3366
 * @create Jan 19, 2021 4:17:09 PM
 */
@SpringBootApplication
@RefreshScope
@EnableEurekaClient
public class ConfigClientMain3366 {
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConfigClientMain3366.class, args);
    }
}
