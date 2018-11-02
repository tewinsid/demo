package com.tewinsid.demo.service.user.impl;

import com.tewinsid.demo.dao.UserMapper;
import com.tewinsid.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements com.tewinsid.demo.service.user.UserService {

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Resource
    private UserMapper userMapper;
}
