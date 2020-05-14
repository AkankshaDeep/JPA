package com.cognizant.ormLearn.Service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormLearn.Model.Skill;
import com.cognizant.ormLearn.Repository.SkillRepository;
@Service
public class SkillService {

	@Autowired
	SkillRepository skillRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	@Transactional 
	public Skill get(int id) { 
	LOGGER.info("Start"); 
	return skillRepository.findById(id).get(); 
	} 
	
	@Transactional 
	public void save(Skill skill) { 
	LOGGER.info("Start");
	skillRepository.save(skill); 
	LOGGER.info("End"); 
	}
}
