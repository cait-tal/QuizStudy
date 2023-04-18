package com.ct.services;

import com.ct.dao.QuizDAOImpl;
import com.ct.exceptions.InvalidQuestionFormatException;
import com.ct.models.Question;

import java.sql.SQLException;


public class QuizServiceImpl implements QuizService{

    private final QuizDAOImpl quizDAO;

    public QuizServiceImpl() {
        this.quizDAO = new QuizDAOImpl();
    }

    public QuizServiceImpl(QuizDAOImpl mockDAOImpl) {
        this.quizDAO = mockDAOImpl;
    }

    public Question addQuestion(Question question) throws InvalidQuestionFormatException, SQLException {
        if(question.getOptions() == null) {
            throw new InvalidQuestionFormatException("Invalid or missing fields. Reformat question.");
        }
        boolean valid = true;
        switch(question.getOptions()) {
            case SIX:
                if(question.getOption5() == null) {
                    valid = false;
                };
            case FIVE:
                if(question.getOption4() == null) {
                    valid = false;
                };
            case FOUR:
                if(question.getOption3() == null) {
                    valid = false;
                };
            case THREE:
                if(question.getOption2() == null) {
                    valid = false;
                };
            case TWO:
                if(question.getOption1() == null) {
                    valid = false;
                };
                break;
            default:
                valid = false;
        }

        if(valid) {
            return quizDAO.addQuestion(question);
        }
        throw new InvalidQuestionFormatException("Invalid question provided.");
    }
}
