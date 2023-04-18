package com.ct.dao;

import com.ct.models.Options;
import com.ct.models.Question;
import com.ct.models.Topic;
import com.ct.utility.ConnectionUtility;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class quizDAOTest {

    @Mock
    Connection mockConnection;

    @Mock
    PreparedStatement mockPreparedStmnt;

    @Mock
    ResultSet mockResultSet;

    Long id = 1L;

    private AutoCloseable closeable;

    @BeforeAll
    private void setUp() throws SQLException {
        closeable = MockitoAnnotations.openMocks(this);
        when(mockConnection.prepareStatement(anyString(), anyInt())).thenReturn(mockPreparedStmnt);
        doNothing().when(mockConnection).setAutoCommit(anyBoolean());
        doNothing().when(mockConnection).commit();
        doNothing().when(mockPreparedStmnt).setString(anyInt(), anyString());
        doNothing().when(mockPreparedStmnt).setLong(anyInt(), anyLong());
        when(mockPreparedStmnt.execute()).thenReturn(Boolean.TRUE);
        when(mockPreparedStmnt.getGeneratedKeys()).thenReturn(mockResultSet);
        when(mockResultSet.getLong(anyInt())).thenReturn(id);
    }

    @AfterAll
    private void close_mocks() throws Exception {
        closeable.close();
    }

    @Test
    void testAddQuestion_positive() throws SQLException {
        when(mockResultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
        try(MockedStatic<ConnectionUtility> classMock = mockStatic(ConnectionUtility.class)) {
            classMock.when(() -> ConnectionUtility.getConnection()).thenReturn(mockConnection);
            QuizDAOImpl instance = new QuizDAOImpl();
            // New question
            Question question = new Question(null, "Test?", Options.TWO, "one", "two", null, null, null, null, new Topic(1L, "Topic"));
            instance.addQuestion(question);
            verify(mockConnection, times(1)).prepareStatement(anyString(), anyInt());
            verify(mockPreparedStmnt, times(4)).setString(anyInt(), anyString());
            verify(mockPreparedStmnt, times(1)).setLong(anyInt(), anyLong());
            verify(mockResultSet, times(1)).next();
            verify(mockResultSet, times(1)).getLong(1);
        }


    }

    @Test
    void testAddQuestion_negative() throws SQLException {
        when(mockResultSet.next()).thenReturn(Boolean.FALSE);
        try(MockedStatic<ConnectionUtility> classMock = mockStatic(ConnectionUtility.class)) {
            classMock.when(() -> ConnectionUtility.getConnection()).thenReturn(mockConnection);
            QuizDAOImpl instance = new QuizDAOImpl();
            Assertions.assertThrows(SQLException.class, () -> {
                instance.addQuestion(new Question(null, null, null, null, null, null, null, null, null, null));
            });
        }
    }
}
