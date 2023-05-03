package com.ct.dao;

import com.ct.models.Quiz;
import com.ct.models.Topic;

import java.sql.SQLException;
import java.util.List;

public interface QuizDAO {
    List<Quiz> getAllQuizzes() throws SQLException;
    List<Quiz> getQuizByTopics(Topic topic);
}
