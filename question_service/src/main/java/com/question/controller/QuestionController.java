package com.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.Question;
import com.question.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	@PostMapping("/create")
	public Question createQuestion(@RequestBody Question q) {
		Question question = service.create(q);
		
		return question;
	}
	
	@GetMapping("/getSingle/{id}")
	public ResponseEntity<Question> getsingleQuestion(@PathVariable Long id) {
		Question question = service.get(id);
		return new ResponseEntity<>(question, HttpStatus.FOUND);
	}
	
	@GetMapping("/getAll")
	public List<Question> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/byId/{quizId}")
	public List<Question> getQuestionbyid(@PathVariable("quizId") Long id){
		
		List<Question> list = service.getQuestionsById(id);
		return list;
	}
}