package com.ChatApp.Chat.App.controller;


import com.ChatApp.Chat.App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class User {

    @Autowired
    private UserService userService;

    public User addUser(User user) {
        userService.saveUser(user);
        return user;
    }


}
