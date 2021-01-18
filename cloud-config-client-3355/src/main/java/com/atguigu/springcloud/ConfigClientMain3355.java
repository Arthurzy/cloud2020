package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author YongZhang
 * @version 1.0
 * @description: ConfigClientMain3355
 * @create Jan 18, 2021 5:37:43 PM
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3355 {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConfigClientMain3355.class, args);
    }

}
