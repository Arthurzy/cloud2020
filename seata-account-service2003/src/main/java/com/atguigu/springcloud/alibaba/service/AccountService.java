package com.atguigu.springcloud.alibaba.service;

import java.math.BigDecimal;

public interface AccountService {

	/**
	 * 扣减余额
	 * @param userid
	 * @param money
	 */
	void decrease(Long userid, BigDecimal money);
}
