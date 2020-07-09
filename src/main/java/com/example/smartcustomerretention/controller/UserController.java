package com.example.smartcustomerretention.controller;

import com.example.smartcustomerretention.repository.UserRepository;
import com.example.smartcustomerretention.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    // Get all users
    @GetMapping("/user")
    public List<User> getAllNotes() {
        return userRepository.findAll();
    }

    // Create a new user
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        //Formatting date
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        user.setCreatedAt(formattedDate);
        // committing the changes to db
        return userRepository.save(user);
    }
}
