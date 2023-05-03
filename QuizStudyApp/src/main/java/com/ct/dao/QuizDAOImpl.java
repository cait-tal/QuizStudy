package com.ct.dao;

import com.ct.models.Quiz;
import com.ct.models.Topic;
import com.ct.utility.ConnectionUtility;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QuizDAOImpl implements QuizDAO{


    @Override
    public List<Quiz> getAllQuizzes() throws SQLException {

        try(Connection con = ConnectionUtility.getConnection()) {
            PreparedStatement pstmt = con.prepareCall("{call getQuizNames()}");

            ResultSet rs = pstmt.executeQuery();
            List<Quiz> quizzes = new ArrayList<>();

            while(rs.next()) {
                quizzes.add(new Quiz(
                       rs.getInt(1), rs.getString(2), rs.getObject(3, LocalDateTime.class),
                        rs.getObject(4, LocalDateTime.class), rs.getInt(5)
                ));
            }
            return quizzes;
        }
    }

    @Override
    public List<Quiz> getQuizByTopics(Topic topic) {
        return null;
    }
}
