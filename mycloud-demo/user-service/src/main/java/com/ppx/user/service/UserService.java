package com.ppx.user.service;


import com.ppx.user.entity.User;

public interface UserService {
    User getById(Long id);

    void login(User user);
}
