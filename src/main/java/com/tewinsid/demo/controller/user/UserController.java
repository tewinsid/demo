package com.tewinsid.demo.controller.user;

import com.tewinsid.demo.model.User;
import com.tewinsid.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/add")
    public User addUser(User user) {
        System.out.println("---------tewinsid----------值=" + user.getName() + "," + "当前类=UserController.addUser()");
        userService.addUser(user);
        return user;
    }

    @Autowired
    private UserService userService;
}
