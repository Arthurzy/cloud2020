package com.atguigu.springcloud.lb;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

/**
 * @author YongZhang
 * @version 1.0
 * @description: MyLB
 * @create Jan 8, 2021 2:01:55 PM
 */
@Component
public class MyLB implements LoadBalancer {
    
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    
    public final int getAndIncrement() {
        int current;
        int next;
        
        do { // 类似自旋锁
            current = this.atomicInteger.get();
            next = current >= 21473647?0:current + 1;  //Integer 最大值  21473647
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*********第几次访问，次数next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        
        int index = getAndIncrement() % serviceInstances.size();
        
        return serviceInstances.get(index);
    }

}


