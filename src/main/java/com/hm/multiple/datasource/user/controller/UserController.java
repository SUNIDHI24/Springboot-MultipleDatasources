package com.hm.multiple.datasource.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hm.multiple.datasource.entity.User;
import com.hm.multiple.datasource.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/getUserById/{id}")
	public Optional<User> findUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	
	@GetMapping("/getAllUser")
	public List<User> allUsers() {
		return userService.findAllUsers();
	}

	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
        //feature-2
	@GetMapping("/getUser/{id}")
	public Optional<User> findUser(@PathVariable int id) {
		return userService.getUserById(id);
	}

	


}
