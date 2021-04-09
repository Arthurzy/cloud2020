package com.atguigu.springcloud.alibaba.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceProxyConfig {
	
	@Value("${mybatis.mapperLocations}")
	private String mapperLocations;
}