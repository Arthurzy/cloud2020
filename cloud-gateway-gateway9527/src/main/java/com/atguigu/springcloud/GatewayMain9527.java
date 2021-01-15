package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author YongZhang
 * @version 1.0
 * @description: GatewayMain9527
 * @create Jan 15, 2021 3:02:33 PM
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
public static void main(String[] args) throws Exception {
    SpringApplication.run(GatewayMain9527.class, args);
}

}


