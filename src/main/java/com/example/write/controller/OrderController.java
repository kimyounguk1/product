package com.example.write.controller;

import com.example.write.entity.Order;
import com.example.write.entity.Product;
import com.example.write.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @Transactional
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest request) {
        OrderResponse orderResponse = orderService.getOrderResponse(request);
        return ResponseEntity.created(URI.create("/api/orders/" + orderResponse.getOrderId())).body(orderResponse);
    }


    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        Order order = orderService.getOrder1(id);
        return ResponseEntity.ok(new OrderResponse(order));
    }

}
