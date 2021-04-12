package com.atguigu.springcloud.alibaba.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.service.AccountService;


@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	/**
	 * 扣减余额
	 * @param productId
	 * @param count
	 * @return
	 */
	@RequestMapping(value = "/account/decrease")
	public CommonResult decrease(@RequestParam("userId")Long userId, 
			@RequestParam("money")BigDecimal money) {
		accountService.decrease(userId, money);;
		return new CommonResult(200, "扣减余额成功");
	}
}
