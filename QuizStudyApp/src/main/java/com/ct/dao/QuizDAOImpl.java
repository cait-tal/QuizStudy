package com.ct.dao;

import com.ct.models.Question;
import com.ct.models.Topic;
import com.ct.utility.ConnectionUtility;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class QuizDAOImpl implements QuizDAO{
    public QuizDAOImpl() throws SQLException {
    }

    // For mocking with tests
    public QuizDAOImpl(DataSource dataSource) throws SQLException {
    }

    @Override
    public Question addQuestion(Question question) throws SQLException {
        try(Connection con = ConnectionUtility.getConnection()) {
            con.setAutoCommit(false);
            String sql = "INSERT INTO quiz_app.questions" +
                    "(question, options, answer, option1, option2, option3, option4, option5, topic_id)" +
                    "VALUES" +
                    "(?, ?, ?, ?, ?, ?, ?, ? , ?)";

            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, question.getText());
            pstmt.setString(2, question.getOptions().toString());
            pstmt.setString(3, question.getAnswer());
            pstmt.setString(4, question.getOption1());
            pstmt.setString(5, question.getOption2());
            pstmt.setString(6, question.getOption3());
            pstmt.setString(7, question.getOption4());
            pstmt.setString(8, question.getOption5());
            pstmt.setLong(9, question.getTopic().getId());

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();

            System.out.println(rs.getInt(1));
        }
        return null;
    }

    @Override
    public Topic addTopic(Topic topic) throws SQLException {
        return null;
    }

    @Override
    public List<Question> getQuizByAmount(int max) throws SQLException {
        return null;
    }

    @Override
    public List<Question> getQuizByTopic(Topic topic) throws SQLException {
        return null;
    }
}
