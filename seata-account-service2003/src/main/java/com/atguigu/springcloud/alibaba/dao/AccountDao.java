package com.atguigu.springcloud.alibaba.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountDao {
	
	/**
	 * 扣减账户余额
	 * @param userid
	 * @param money
	 */
	void decrease(@Param("userId") Long userid,@Param("money") BigDecimal money);
}
