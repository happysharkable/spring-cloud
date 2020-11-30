package com.springcloud.products;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("products-ms")
public interface ProductController {
}
