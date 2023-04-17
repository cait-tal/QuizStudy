package com.ct.dao;

import com.ct.models.Question;
import com.ct.models.Topic;

import java.sql.SQLException;
import java.util.List;

public interface QuizDAO {
    Question addQuestion(Question question) throws SQLException;
    Topic addTopic(Topic topic) throws SQLException;
    List<Question> getQuizByAmount(int max) throws SQLException;
    List<Question> getQuizByTopic(Topic topic) throws SQLException;
}
