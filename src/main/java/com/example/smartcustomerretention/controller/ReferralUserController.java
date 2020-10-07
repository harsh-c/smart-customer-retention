package com.example.smartcustomerretention.controller;
import com.example.smartcustomerretention.models.ReferralUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.smartcustomerretention.repository.ReferralUserRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReferralUserController {
    @Autowired
    ReferralUserRepository referralUserRepository;

    // Get all referral users mapping
    @GetMapping("/referral_user")
    public List<ReferralUser> getAllReferralUsers(){
        return referralUserRepository.findAll();
    }

    // Add a mapping in referral users
    @PostMapping("/referral_user")
    public ReferralUser addReferralUser(@RequestBody ReferralUser referralUser){
        referralUser.setCreatedAt(referralUser.getCreatedAt());

        return referralUserRepository.save(referralUser);
    }
}
