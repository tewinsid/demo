package com.tewinsid.demo.dao;

import com.tewinsid.demo.model.User;

import java.util.List;


public interface UserMapper {
    int insert(User user);

    List<User> getAll();

    User getUserById(String id);
}
