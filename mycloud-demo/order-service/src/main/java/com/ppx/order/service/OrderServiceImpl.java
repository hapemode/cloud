package com.ppx.order.service;

import com.ppx.order.entity.Order;
import com.ppx.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Override
    public Order getByOrderId(Long orderId) {
        return orderMapper.getByOrderId(orderId);
    }
}
