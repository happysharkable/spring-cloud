package com.springcloud.orders.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private String title;
    private int quantity;
    private int cost;
}
