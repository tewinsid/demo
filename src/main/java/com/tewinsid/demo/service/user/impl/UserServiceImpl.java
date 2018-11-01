package com.tewinsid.demo.service.user.impl;

import com.tewinsid.demo.dao.UserMapper;
import com.tewinsid.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements com.tewinsid.demo.service.user.UserService {

    @Override
    public User addUser(User user) {
        return userMapper.insert(user);
    }

    @Autowired
    private UserMapper userMapper;
}
