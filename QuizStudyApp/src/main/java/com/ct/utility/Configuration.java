package com.ct.utility;

import com.ct.dao.QuizDAOImpl;
import com.ct.exceptions.GlobalExceptionController;
import com.ct.services.QuizServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Configuration {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final QuizDAOImpl QUIZ_DAO = new QuizDAOImpl();
    private static final QuizServiceImpl QUIZ_SERVICE = new QuizServiceImpl(QUIZ_DAO);
    private static final GlobalExceptionController GLOBAL_EXCEPTION_CONTROLLER = new GlobalExceptionController(OBJECT_MAPPER);

    static {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
    }

    protected static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    protected static QuizServiceImpl getQuizService() {
        return QUIZ_SERVICE;
    }

    protected static QuizDAOImpl getQuizDao() {
        return QUIZ_DAO;
    }

    protected static GlobalExceptionController getGlobalExceptionController() {
        return GLOBAL_EXCEPTION_CONTROLLER;
    }
}
