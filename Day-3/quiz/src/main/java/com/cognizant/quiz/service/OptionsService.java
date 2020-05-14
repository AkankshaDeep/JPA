package com.cognizant.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.quiz.repository.OptionsRepository;

@Service
public class OptionsService {

	@Autowired
	OptionsRepository optionsRepository;
}
