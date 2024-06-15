package com.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entity.Question;
import com.question.repository.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public Question create(Question q) {
		Question question = questionRepo.save(q);
		return question;
	}
	
	@Override
	public Question get(Long id) {
		Question question = questionRepo.findById(id).orElseThrow(()->new RuntimeException("question with given id is not found.."));
		return question;
	}
	
	@Override
	public List<Question> getAll() {
		List<Question> list = questionRepo.findAll();
		return list;
	}
	
	@Override
	public List<Question> getQuestionsById(Long id) {
		List<Question> list = questionRepo.findByQuizId(id);
		return list;
	}
}
