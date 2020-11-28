package com.springcloud.orders.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private Long id;
    private List<OrderItem> items;
}
