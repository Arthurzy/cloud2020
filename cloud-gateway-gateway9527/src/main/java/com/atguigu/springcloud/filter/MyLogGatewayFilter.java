package com.atguigu.springcloud.filter;

import java.util.Date;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author YongZhang
 * @version 1.0
 * @description: MyLogGatewayFilter
 * @create Jan 18, 2021 11:50:38 AM
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered{

    @Override
    public int getOrder() {
        // a.值越小权重越大
        return 0;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        
        log.info("************ come in my global gateway filter: " + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null) {
            log.info("************用户名为null,非法用户.");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        
        return chain.filter(exchange);
    }

}


