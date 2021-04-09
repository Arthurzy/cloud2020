package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.atguigu.springcloud.alibaba.domain.Order;

@Mapper
public interface OrderDao {
	
	/**
	 * 1 新建订单
	 * @param order
	 * @return
	 */
	public int create(Order order);
	
	/**
	 * 2 修改订单状态,从0改为1
	 * @param userId
	 * @param status
	 * @return
	 */
	public int update(@Param("userId") Long userId, @Param("status") Integer status);
 	
}
