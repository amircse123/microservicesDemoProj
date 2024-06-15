package com.quiz.controller;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;

	@PostMapping("/create")
	public Quiz createQuiz(@RequestBody Quiz q ) {
		Quiz quiz = quizService.add(q);
		return quiz;
	}
	
	@GetMapping("/getQuiz/{id}")
	public Quiz getsingleQuiz(@PathVariable Long id){
		return quizService.get(id);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Quiz>> getAllQuiz(){
		
		
		List list=quizService.get();
		return new ResponseEntity<List<Quiz>>(list, HttpStatus.FOUND);
	}
	
	@PutMapping("/update/{id}")
	public Quiz updateQuiz(@RequestBody Quiz q,@PathVariable Long id) {
		return quizService.updateQuiz(q, id);
	}
}