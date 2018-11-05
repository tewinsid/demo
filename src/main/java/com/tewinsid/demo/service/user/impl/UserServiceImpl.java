package com.tewinsid.demo.service.user.impl;

import com.tewinsid.demo.dao.UserMapper;
import com.tewinsid.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements com.tewinsid.demo.service.user.UserService {

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> getUserAll() {
        return userMapper.getAll();
    }

    @Override
    public User getUserById(String id) {
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(id)) {
            System.out.println("get from redis");
            return operations.get(id);
        }
        User user = userMapper.getUserById(id);
        operations.set(id, user);
        return user;
    }

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;
}
