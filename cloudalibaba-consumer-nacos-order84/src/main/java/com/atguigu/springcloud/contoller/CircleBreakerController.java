package com.atguigu.springcloud.contoller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

@RestController
public class CircleBreakerController {
	
	public static String SERVICE_URL="http://nacos-payment-provider";

	@Resource
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/consumer/fallback/{id}")
	@SentinelResource(value = "fallback") // 没有配置
//	@SentinelResource(value = "fallback", fallback = "handlerFallback") // fallback只负责业务异常
//	@SentinelResource(value = "fallback", blockHandler = "blockHandler") // blockHandler只负责sentinel控制台配置违规
//	@SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")
	public CommonResult<Payment> fallback(@PathVariable("id")Long id) {
		CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
		if (id == 4) {
			throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常......");
		}else if (result.getData() == null){
			throw new NullPointerException("NullPointerException, 该ID没有对应记录，空指针异常......");
		}
		
		return result;
	}
	
	public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id, Throwable e){
		Payment payment = new Payment(id, null);
		return new CommonResult<Payment>(444, "兜底异常handlerFallback, exception内容 " + e.getMessage(), payment);
		
	}
}
