package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author YongZhang
 * @version 1.0
 * @description: HystrixDashboardMain9001
 * @create Jan 14, 2021 3:59:52 PM
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }

}


