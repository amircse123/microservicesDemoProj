package com.quiz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.entities.Quiz;
import com.quiz.repository.QuizRepo;


@Service
public class QuizServiceImpl implements QuizService{
	
	private QuizRepo quizRepo;
	
	private QuestionClient questionClient;

	
	public QuizServiceImpl(QuizRepo quizRepo, QuestionClient questionClient) {
		super();
		this.quizRepo = quizRepo;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		
		return quizRepo.save(quiz);
	}

	@Override
	public List<Quiz> get() {

		 List<Quiz> quizzes = quizRepo.findAll();
		 List<Quiz> newQuizList = quizzes.stream().map(quiz->{
			 quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getQuizId()));
			 return quiz;
		 }).collect(Collectors.toList());
		 return newQuizList;
	}

	
	@Override
	public Quiz get(Long id) {
		Quiz quiz = quizRepo.findById(id).orElseThrow(()->new RuntimeException("quiz not found"));
		quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getQuizId()));
		return quiz;
		
	}
	
	@Override
	public Quiz updateQuiz(Quiz q, Long id) {
		Quiz quiz = quizRepo.findById(id).orElseThrow(()->new RuntimeException("quiz not found"));
		quiz.setTitle(q.getTitle());
		Quiz saved = quizRepo.save(quiz);
		return saved;
	}

}
