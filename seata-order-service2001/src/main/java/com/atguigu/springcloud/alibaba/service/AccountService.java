package com.atguigu.springcloud.alibaba.service;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.springcloud.alibaba.domain.CommonResult;

@FeignClient(value = "seata-account-service")
public interface AccountService {

	@PostMapping(value = "/account/decrease")
	CommonResult decrease(@RequestParam("userId")Long usertId, 
			@RequestParam("money")BigDecimal money);
}