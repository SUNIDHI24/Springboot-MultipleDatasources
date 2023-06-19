package com.hm.multiple.datasource.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hm.multiple.datasource.entity.User;
import com.hm.multiple.datasource.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@EnableTransactionManagement
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}

	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Transactional
	public User addUser(User user) {
		return userRepository.save(user);
	}
}
