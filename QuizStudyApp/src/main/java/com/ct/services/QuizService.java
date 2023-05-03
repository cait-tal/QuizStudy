package com.ct.services;

import com.ct.exceptions.InvalidQuestionFormatException;
import com.ct.models.Quiz;

import java.sql.SQLException;
import java.util.List;

public interface QuizService {
    List<Quiz> getAllQuizzes() throws SQLException;
}
