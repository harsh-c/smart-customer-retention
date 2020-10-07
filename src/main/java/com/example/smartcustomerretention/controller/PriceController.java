package com.example.smartcustomerretention.controller;

import com.example.smartcustomerretention.models.Price;
import com.example.smartcustomerretention.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PriceController {
    @Autowired
    PriceRepository priceRepository;

    // Get prices for all users
    @GetMapping("/get-all-prices")
    public List<Price> getAllUsers() {
        return priceRepository.findAll();
    }

    // Post a new record in the price table
    @PostMapping("/get-all-prices")
    public Price addPrice(@RequestBody Price price){
        //Formatting date
        price.setCreatedAt(price.getCreatedAt());
        return priceRepository.save(price);
    }

}
