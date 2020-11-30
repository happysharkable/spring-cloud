package com.springcloud.orders;

import com.springcloud.common.ProductDTO;
import com.springcloud.orders.dto.OrderDTO;
import com.springcloud.orders.dto.OrderItemDTO;
import com.springcloud.orders.entities.Order;
import com.springcloud.orders.entities.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@EnableEurekaClient
public class OrderControllerImpl implements OrderService {
    private List<Order> orders;
    private RestTemplate restTemplate;

    @Autowired
    private void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    private void init() {
        orders = new ArrayList<>();
        orders.addAll(Arrays.asList(
                new Order(1L, Arrays.asList(
                        new OrderItem(2L, 3), new OrderItem(1L, 1)
                )),
                new Order(2L, Arrays.asList(
                        new OrderItem(3L, 10), new OrderItem(1L,5)
                ))
        ));
    }

    @GetMapping("/orders")
    public List<OrderDTO> getAllOrders() {
        return orders.stream().map(this::convertOrderToOrderDTO).collect(Collectors.toList());
    }

    @GetMapping("/orders/{id}")
    public OrderDTO getOrderById(@PathVariable(value = "id") Long id) {
        return orders.stream().filter(o -> o.getId().equals(id)).findFirst().map(this::convertOrderToOrderDTO).get();
    }

    @PostMapping("/orders/new")
    public void createNewOrder(@RequestBody List<OrderItem> items) {
        orders.add(new Order(getNextOrderId(), items));
    }

    private Long getNextOrderId() {
        return orders.size() + 1L;
    }

    private OrderDTO convertOrderToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO(order.getId(), new ArrayList<>());
        for (OrderItem oi : order.getItems()) {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
//            ProductDTO p = restTemplate.getForObject("http://localhost:19872/products/" + oi.getId().toString(), ProductDTO.class);
            String request = "http://products-ms/products/" + oi.getId().toString();
            ProductDTO p = restTemplate.getForObject(request, ProductDTO.class);
            if (p != null) {
                orderItemDTO.setTitle(p.getTitle());
                orderItemDTO.setCost(p.getCost());
                orderItemDTO.setQuantity(oi.getQuantity());
            }
            orderDTO.getItems().add(orderItemDTO);
        }
        return orderDTO;
    }
}
