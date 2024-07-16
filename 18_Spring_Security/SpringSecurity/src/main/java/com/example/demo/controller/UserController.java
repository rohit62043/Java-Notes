package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.gerUsers();
    }

    @PostMapping("/register")
    public User postUser(@RequestBody User user){

        return userService.postUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if (authentication.isAuthenticated()){
            return "Successful";
        }

        return "Login Fail";
    }
}
