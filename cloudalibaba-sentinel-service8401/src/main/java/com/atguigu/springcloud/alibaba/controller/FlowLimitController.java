package com.atguigu.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YongZhang
 * @version 1.0
 * @description: FlowLimitController
 * @create Mar 16, 2021 5:00:43 PM
 */
@RestController
public class FlowLimitController {
        
    @GetMapping("/testA")
    public String testA() {
        return "------------testA()";
    }
    
    @GetMapping("/testB")
    public String testB() {
        return "------------testB()";
    }

}


