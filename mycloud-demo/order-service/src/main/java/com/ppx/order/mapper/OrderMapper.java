package com.ppx.order.mapper;

import com.ppx.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Order getByOrderId(Long orderId);
}
