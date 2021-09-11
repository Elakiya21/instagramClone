package com.clone.instagram.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.instagram.entity.Users;
import com.clone.instagram.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Users submitMetaDataOfUser(Users users) {
		return userRepository.save(users);
	}

	public Users displayMetaDataOfUser(String id) {
		return userRepository.findByUserId(id);
	}
	public Users submitProfilePicOfUser(String id,String profileImage) {
		
		Users u=userRepository.findByUserId(id);
		u.setProfileImage(profileImage);
		return userRepository.save(u);
	}
}
