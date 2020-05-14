package com.cognizant.quiz;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.cognizant.quiz.model.Attempt;
import com.cognizant.quiz.model.AttemptOption;
import com.cognizant.quiz.model.Options;
import com.cognizant.quiz.model.Question;
import com.cognizant.quiz.service.AttemptService;
import com.cognizant.quiz.service.OptionsService;
import com.cognizant.quiz.service.QuestionService;
import com.cognizant.quiz.service.UserService;

@SpringBootApplication
public class QuizApplication {

	public static AttemptService attemptService;
	
	
	public static OptionsService optionsService;
	public static QuestionService questionService;
	public static UserService userService;
	private static final Logger LOGGER = LoggerFactory.getLogger(QuizApplication.class);
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(QuizApplication.class, args);
		attemptService = context.getBean(AttemptService.class);
		
		optionsService = context.getBean(OptionsService.class);
		questionService = context.getBean(QuestionService.class);
		userService = context.getBean(UserService.class);
		
		testGetAttemptDetail();
		
		
	}
	private static void testGetAttemptDetail() {
		// TODO Auto-generated method stub
		LOGGER.info("Start"); 
		//Attempt attempt= attemptService.getAttemptDetail(1, 1);
		Attempt attempt=attemptService.getAttemptList(1,1);
		
		Set<Question> questionList=attempt.getQuestionList();
		Set<Options> optinList=attempt.getOptionList();
		
		for(Question q:questionList) {
			System.out.println(q.getQt_text());
			Set<Options> optionList=q.getOptionsList();
			Set<AttemptOption> attemptOptionsSet;
			int c=1;
			for(Options o:optionList) {
				attemptOptionsSet=o.getAttemptOptionList();	
				for(AttemptOption ao:attemptOptionsSet) 				
			System.out.print(c+") "+o.getOp_text()+" "+o.getOp_score()+" "+ao.isAo_selected());
			System.out.println();
			c++;
			}
			
		}
		LOGGER.debug("Attempt:{}", attempt); 
		 
		LOGGER.info("End"); 
	}
	
	

}
