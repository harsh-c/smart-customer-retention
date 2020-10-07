package com.example.smartcustomerretention.controller;

import com.example.smartcustomerretention.models.User;
import com.example.smartcustomerretention.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    // Get all users
    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Create a new user
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {

        user.setCreatedAt(user.getCreatedAt());
        // committing the changes to db
        logger.info(String.format("#### -> received add user request -> %s", user.toString()));
        return userRepository.save(user);
    }
}
