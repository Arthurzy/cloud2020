package com.atguigu.springcloud.alibaba.controller;

import java.util.concurrent.TimeUnit;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        // 暂停毫秒
        try {
            TimeUnit.MICROSECONDS.sleep(800);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "------------testA()";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "-------testB"); // 测试排队
        return "------------testB()";
    }

    @GetMapping("/testD")
    public String testD() {
        // try {
        // TimeUnit.SECONDS.sleep(1);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // log.info("testD 测试RT");
        log.info("testD 异常比例");
        int age = 10 / 0;
        return "------------testD()";
    }

    @GetMapping("/testE")
    public String testE() {

        log.info("testE 异常数");
        int age = 10 / 0;
        return "------------testE() 测试异常数";
    }

    @GetMapping("testHotkey")
    @SentinelResource(value = "testHotkey", blockHandler = "deal_testHotkey")
    public String testHotkey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "---testHotkey";
    }

    public String deal_testHotkey(String p1, String p2, BlockException exception){
        return "---deal_testHotkey"; // sentinel 系统默认的提示：Block by sentinel(flow limiting)
    }
}
