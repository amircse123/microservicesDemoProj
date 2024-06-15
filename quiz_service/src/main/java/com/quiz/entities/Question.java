package com.quiz.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
public class Question {

	private Long questionId;
	private String question;
	private Long quizId;
}