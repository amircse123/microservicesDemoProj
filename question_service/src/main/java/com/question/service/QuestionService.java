package com.question.service;

import java.util.List;

import com.question.entity.Question;

public interface QuestionService {

	Question create(Question q);

	Question get(Long id);

	List<Question> getAll();
	
	List<Question> getQuestionsById(Long id);
}
