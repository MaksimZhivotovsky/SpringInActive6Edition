package com.example.max.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.max.model.User;
import com.example.max.model.UserRepo;
import com.example.max.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encoder;
	
	public void createUser(UserRepo userRepo) {
		User user = new User();
		user.setUsername(userRepo.getUsername());
		user.setPassword(encoder.encode(userRepo.getPassword()));
		userRepository.save(user);
	}
}
