package com.cognizant.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.quiz.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
}
