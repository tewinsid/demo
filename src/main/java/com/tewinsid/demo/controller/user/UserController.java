package com.tewinsid.demo.controller.user;

import com.tewinsid.demo.model.User;
import com.tewinsid.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/add")
    public User addUser(User user) {
        System.out.println("---------tewinsid----------值=" + user.getName() + "," + "当前类=UserController.addUser()");
        userService.addUser(user);
        return user;
    }

    @RequestMapping("/get")
    public List<User> getUserAll() {
        return userService.getUserAll();
    }

    @RequestMapping("/fetch")
    public User fetch(String id) {
        System.out.println(id);
        return userService.getUserById(id);
    }

    @Autowired
    private UserService userService;
}
