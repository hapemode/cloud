package com.ppx.order.service;

import com.ppx.order.entity.Order;

public interface OrderService {

    Order getByOrderId(Long orderId);
}
