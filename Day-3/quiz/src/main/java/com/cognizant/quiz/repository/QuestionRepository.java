package com.cognizant.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.quiz.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {

}
