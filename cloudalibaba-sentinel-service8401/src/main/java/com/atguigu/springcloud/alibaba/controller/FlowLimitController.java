package com.atguigu.springcloud.alibaba.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author YongZhang
 * @version 1.0
 * @description: FlowLimitController
 * @create Mar 16, 2021 5:00:43 PM
 */
@RestController
@Slf4j
public class FlowLimitController {
        
    @GetMapping("/testA")
    public String testA() {
        return "------------testA()";
    }
    
    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "-------testB"); // 测试排队
        return "------------testB()";
    }
    
    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "------------testD()";
    }

}


