package com.example.write.controller;

import com.example.write.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private long orderId;

    public OrderResponse(Order saved) {
        this.orderId = saved.getId();
    }
}
