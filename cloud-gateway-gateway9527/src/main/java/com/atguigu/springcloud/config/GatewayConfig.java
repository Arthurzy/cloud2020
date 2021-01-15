package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YongZhang
 * @version 1.0
 * @description: GatewayConfig
 * @create Jan 15, 2021 4:16:49 PM
 */
@Configuration
public class GatewayConfig {
    
    /**
     * a.配置了一个id为path_route_atguigu的路由规则
     * b.当访问地址localhost:9527/guonei时，会自动转发到http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
               .route("path_route_atguigu", r->r.path("/guonei").uri("http://news.baidu.com/guonei"))
               .route("path_route_atguigu2", r->r.path("/guoji").uri("http://news.baidu.com/guoji"))
               .build();
    }
}


