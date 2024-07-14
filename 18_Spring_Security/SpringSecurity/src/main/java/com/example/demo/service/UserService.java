package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepository userRepository;
    public List<User> gerUsers(){
        return userRepository.findAll();
    }

    public Optional<User> postUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return userRepository.findById(user.getId());
    }
}
