package com.springcloud.orders.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private List<OrderItemDTO> items;
}
