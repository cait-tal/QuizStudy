package com.ct.controllers;

import com.ct.services.QuizServiceImpl;


public class QuizController{

    private QuizServiceImpl quizService;

    public QuizController() {
        this.quizService = new QuizServiceImpl();
    }

    public QuizController(QuizServiceImpl mockQuizService) {
        this.quizService = mockQuizService;
    }

}
