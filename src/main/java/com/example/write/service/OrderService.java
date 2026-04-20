package com.example.write.service;

import com.example.write.controller.OrderRequest;
import com.example.write.controller.OrderResponse;
import com.example.write.entity.Order;
import com.example.write.entity.Product;
import com.example.write.repository.OrderRepository;
import com.example.write.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository ;
    private final OrderRepository orderRepository;

    public OrderResponse getOrderResponse(OrderRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "해당 상품이 존재하지 않습니다. id=" + request.getProductId()));

        Order order = new Order(product);
        Order saved = orderRepository.save(order);

        return new OrderResponse(saved);
    }

    public Order getOrder1(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "해당 주문이 존재하지 않습니다. id=" + id));
        return order;
    }

}
