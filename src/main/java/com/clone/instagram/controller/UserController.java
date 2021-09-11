package com.clone.instagram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.instagram.entity.Users;
import com.clone.instagram.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("")
	public Users submitUser(@RequestBody Users users) {

		return userService.submitMetaDataOfUser(users);
	}

	@GetMapping("/{userId}")
	public Users getUserDetails(@PathVariable("userId") String userId) {
		return userService.displayMetaDataOfUser(userId);
	}

	@PutMapping("")
	Users submitUserPicture(@RequestBody Users user) {
		return userService.submitProfilePicOfUser(user.getUserId(), user.getProfileImage());

	}
}
