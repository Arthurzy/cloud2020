package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.service.StorageService;

@RestController
public class StorageController {

	@Autowired
	private StorageService storageService;
	
	/**
	 * 扣减库存
	 * @param productId
	 * @param count
	 * @return
	 */
	@RequestMapping(value = "/storage/decrease")
	public CommonResult decrease(@RequestParam("productId")Long productId, 
			@RequestParam("count")Integer count) {
		storageService.decrease(productId, count);
		return new CommonResult(200, "扣减库存成功");
	}
}
