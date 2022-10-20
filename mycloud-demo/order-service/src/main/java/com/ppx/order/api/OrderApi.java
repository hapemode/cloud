package com.ppx.order.api;

import com.ppx.order.client.UserClient;
import com.ppx.order.entity.Order;
import com.ppx.order.entity.User;
import com.ppx.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderApi {

    @Autowired
    OrderService orderService;

//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    UserClient userClient;

    @GetMapping("/{orderId}")
    public Order getByOrderId(@PathVariable("orderId") Long orderId) {
        Order order = orderService.getByOrderId(orderId);

        // restTemplate调用
//        String url = "http://localhost:9080/user/" + order.getUserId();
        // eureka注册多个实例根据服务名称调用
//        String url = "http://userserver/user/" + order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
//        order.setUser(user);

        // feign调用
        System.out.println("userClient***************** = " + userClient);
        User user = userClient.getById(order.getUserId());
        order.setUser(user);
        return order;
    }

    @GetMapping("/get")
    public String getStr() {
        return "GGGG";
    }
}
