package com.tewinsid.demo.controller.user;

import com.google.gson.Gson;
import com.tewinsid.demo.model.User;
import com.tewinsid.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {


    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String addUser(User user) {
        Gson gson = new Gson();
        return gson.toJson(userService.addUser(user));
    }


    @Autowired
    private UserService userService;
}
