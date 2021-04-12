package com.atguigu.springcloud.alibaba.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

import io.seata.rm.datasource.DataSourceProxy;

/**
 * @author YongZhang
 * 使用seata对数据源进行代理
 */
@Configuration
public class DataSourceProxyConfig {
	
	@Value("${mybatis.mapper-locations}")
	private String mapperLocations;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}
	
	@Bean
	public DataSourceProxy dataSourceProxy(DataSource druidDataSource) {
		return new DataSourceProxy(druidDataSource);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSourceProxy);
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources(mapperLocations));
		return sqlSessionFactoryBean.getObject();
	}
}