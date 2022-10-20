package com.ppx.user.service;

import com.ppx.user.common.BasicException;
import com.ppx.user.entity.User;
import com.ppx.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User getById(Long id) {
        return userMapper.getById(id);
    }

    @Override
    public void login(User user) {
        int num = userMapper.login(user);
        if (num!=1){
            throw new BasicException(100,"用户不存在");
        }
    }
}
