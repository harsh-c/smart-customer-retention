package com.example.smartcustomerretention;
import db.user;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController

public class SmartCustomerRetentionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartCustomerRetentionApplication.class, args);
	}
	@GetMapping("/add")
	public String addUser(@RequestParam String user, @RequestParam String referred_user)  {
		user add = new user();
		add.add_user(user, referred_user);
		return String.format("Added user"+ user +" and referred user "+ referred_user );
	}
	@GetMapping("/getuser")
	public String getUser(@RequestParam String user_name){
		user user = new user();
		List<String> list = new ArrayList<String>();
		list = user.get_users(user_name);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i<list.size()) {
			sb.append(list.get(i) + ", ");
			i++;
		}
		return  sb.toString();
	}
}
