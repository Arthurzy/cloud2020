package com.atguigu.springcloud.lb;


import java.util.List;

import org.springframework.cloud.client.ServiceInstance;

/**
 * @author YongZhang
 * @version 1.0
 * @description: LoadBalancer
 * @create Jan 8, 2021 1:52:40 PM
 */
public interface LoadBalancer {
    
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}


