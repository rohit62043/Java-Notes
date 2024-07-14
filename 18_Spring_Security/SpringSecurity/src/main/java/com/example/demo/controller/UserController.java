package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.gerUsers();
    }

    @PostMapping("/user")
    public Optional<User> postUser(@RequestBody User user){

        return userService.postUser(user);
    }
}
