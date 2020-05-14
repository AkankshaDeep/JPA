package com.cognizant.quiz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.quiz.model.Attempt;
import com.cognizant.quiz.repository.AttemptRepository;

@Service
public class AttemptService {

	@Autowired
	AttemptRepository attemptRepository;	
		
		@Transactional
		public Attempt getAttemptList(int usId,int atId) {
			Attempt attempt=attemptRepository.getAttemptList(usId,atId);
			
			return attempt;	
			
		}
	
}
