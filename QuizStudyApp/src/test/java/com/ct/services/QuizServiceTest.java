package com.ct.services;

import com.ct.dao.QuizDAOImpl;
import com.ct.exceptions.InvalidQuestionFormatException;
import com.ct.models.Options;
import com.ct.models.Question;
import com.ct.models.Topic;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuizServiceTest {

    @Mock
    QuizDAOImpl quizDAO;

    @InjectMocks
    QuizServiceImpl quizService;

    private AutoCloseable closeable;

    @BeforeAll
    void set_up() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterAll
    void close_mocks() throws Exception {
        closeable.close();
    }

    @Test
    public void testAddQuestion_positive() throws SQLException, InvalidQuestionFormatException {
        Question testQuestion = new Question(null, "Test", Options.TWO, "Opt1", "Opt2", null, null, null, null, new Topic(1L, "Topic"));

        Question expected = new Question(1L, "Test", Options.TWO, "Opt1", "Opt2", null, null, null, null, new Topic(1L, "Topic"));

        when(quizDAO.addQuestion(testQuestion)).thenReturn(expected);

        Question actual = quizService.addQuestion(testQuestion);

        Assertions.assertEquals(expected, actual);
    }
}
