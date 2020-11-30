package com.springcloud.orders.entities;

import com.springcloud.common.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItem {
    private Long id;
    private int quantity;
}
