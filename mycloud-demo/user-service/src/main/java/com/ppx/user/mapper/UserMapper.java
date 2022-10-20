package com.ppx.user.mapper;

import com.ppx.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getById(Long id);

    int login(User user);
}
