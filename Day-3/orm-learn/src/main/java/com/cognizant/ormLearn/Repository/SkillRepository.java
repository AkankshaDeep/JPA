package com.cognizant.ormLearn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cognizant.ormLearn.Model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer>{

}
