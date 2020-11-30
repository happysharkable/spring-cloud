package com.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private String title;
    private int cost;

    ProductDTO() {

    }
}
