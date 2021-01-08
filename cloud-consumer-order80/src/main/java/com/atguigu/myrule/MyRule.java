package com.atguigu.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * @author YongZhang
 * @version 1.0
 * @description: MyRule
 * @create Jan 8, 2021 1:46:00 PM
 */
@Configuration
public class MyRule {

    @Bean
    public IRule getIRule() {
        return new RoundRobinRule();
    }
}


