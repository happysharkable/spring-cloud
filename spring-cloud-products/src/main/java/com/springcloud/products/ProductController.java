package com.springcloud.products;

import com.springcloud.common.ProductDTO;
import com.springcloud.products.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>();
        products.addAll(Arrays.asList(
                new Product(1L, "Bread", 50),
                new Product(2L, "Milk", 100),
                new Product(3L, "Eggs", 120)));
    }

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        return products.stream().map(p -> new ProductDTO(p.getTitle(), p.getPrice())).collect(Collectors.toList());
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProductById(@PathVariable(value = "id") Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst()
                .map(p -> new ProductDTO(p.getTitle(), p.getPrice())).get();
    }
}
