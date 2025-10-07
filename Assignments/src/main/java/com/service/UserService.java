package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.UserRepository;
import com.model.User;


@Service
public class UserService {
	
	@Autowired
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public String getUserNameById(Long id) {
		return userRepository.findById(id).map(User::getUname)
				.orElse("Unknown");
	}
	

}
