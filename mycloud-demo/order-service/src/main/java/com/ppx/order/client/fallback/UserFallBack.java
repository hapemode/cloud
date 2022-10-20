package com.ppx.order.client.fallback;

import com.ppx.order.client.UserClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserFallBack implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable cause) {
        log.error("####################调用异常,啥原因{}",cause);
        return null;
    }
}
