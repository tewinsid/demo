package com.tewinsid.demo.service.user;

import com.tewinsid.demo.model.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    List<User> getUserAll();

    User getUserById(String id);
}
