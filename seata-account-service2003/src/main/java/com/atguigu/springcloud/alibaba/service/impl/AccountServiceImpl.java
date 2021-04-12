package com.atguigu.springcloud.alibaba.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.atguigu.springcloud.alibaba.dao.AccountDao;
import com.atguigu.springcloud.alibaba.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Resource
	private AccountDao accountDao;

	/**
	 * 扣减账户约
	 */
	@Override
	public void decrease(Long userid, BigDecimal money) {
		// TODO Auto-generated method stub
		LOGGER.info("---------------->account-service中扣减账户余额开始");
		// a 模拟超时异常，全局事务回滚
		accountDao.decrease(userid, money);
		LOGGER.info("---------------->account-service中扣减账户余额结束");
	}

}
