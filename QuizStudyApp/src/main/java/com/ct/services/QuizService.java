package com.ct.services;

import com.ct.exceptions.InvalidQuestionFormatException;
import com.ct.models.Question;

import java.sql.SQLException;

public interface QuizService {
    Question addQuestion(Question question) throws InvalidQuestionFormatException, SQLException;
}
