package com.cognizant.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.quiz.model.Options;

@Repository
public interface OptionsRepository extends JpaRepository<Options, String> {

}