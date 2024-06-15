package com.quiz.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.entities.Question;

@FeignClient(name="QUESTION-SERVICE")
public interface QuestionClient {

	@GetMapping("/question/byId/{quizId}")
	List<Question> getQuestionsOfQuiz(@PathVariable("quizId") Long id);
	
}
