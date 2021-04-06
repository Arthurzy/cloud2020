package com.atguigu.springcloud.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

@RestController
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;
	
	public static HashMap<Long, Payment> hashMap = new HashMap<>();
	
	static {
		hashMap.put(1L, new Payment(1L, "1234567"));
		hashMap.put(2L, new Payment(2L, "2345678"));
		hashMap.put(3L, new Payment(3L, "3456789"));
	}
	
	@GetMapping(value = "/paymentSQL/{id}")
	public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
		Payment payment = hashMap.get(id);
		CommonResult<Payment> result = new CommonResult<Payment>(200, "from mysql, server port: " + serverPort, payment);
		return result;
	}
}
