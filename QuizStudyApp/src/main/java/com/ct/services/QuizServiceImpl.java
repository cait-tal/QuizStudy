package com.ct.services;

import com.ct.dao.QuizDAOImpl;
import com.ct.exceptions.InvalidQuestionFormatException;
import com.ct.models.Quiz;

import java.sql.SQLException;
import java.util.List;


public class QuizServiceImpl implements QuizService{

    private final QuizDAOImpl quizDAO;

    public QuizServiceImpl() {
        this.quizDAO = new QuizDAOImpl();
    }

    public QuizServiceImpl(QuizDAOImpl mockDAOImpl) {
        this.quizDAO = mockDAOImpl;
    }

    @Override
    public List<Quiz> getAllQuizzes() throws SQLException {
        return quizDAO.getAllQuizzes();
    }
}
