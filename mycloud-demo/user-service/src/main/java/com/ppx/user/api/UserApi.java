package com.ppx.user.api;


import com.ppx.user.config.PatternProperties;
import com.ppx.user.entity.User;
import com.ppx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/user")
@RefreshScope// 配置文件热更新注解
public class UserApi {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id,
                        @RequestHeader(value = "say",required = false) String say) {
        System.out.println("say = " + say);
        return userService.getById(id);
    }

    /*配置热更新两种方式
    方式一:@Value注解+@RefreshScope注解
    方式二:@ConfigurationProperties注解*/

    // 属性注入
//    @Value("${pattern.dateformat}")
//    private String dateformat;

    @Autowired
    PatternProperties patternProperties;

    @GetMapping("/now")
    public String getNow() {
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
    }

    @GetMapping("/property")
    public PatternProperties getPatternProperties() {
        return patternProperties;
    }

    @PostMapping("/login")
    public void login(@RequestBody User user){
        try {
            userService.login(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
