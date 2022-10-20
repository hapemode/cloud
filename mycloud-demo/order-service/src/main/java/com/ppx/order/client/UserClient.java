package com.ppx.order.client;

import com.ppx.order.client.fallback.UserFallBack;
import com.ppx.order.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userserver"
        , fallbackFactory = UserFallBack.class
)
public interface UserClient {

    @GetMapping("/user/{id}")
    public User getById(@PathVariable("id") Long id);
}
