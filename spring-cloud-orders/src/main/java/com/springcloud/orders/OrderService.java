package com.springcloud.orders;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("orders-ms")
public interface OrderService {
}
