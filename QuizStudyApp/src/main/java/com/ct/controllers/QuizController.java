package com.ct.controllers;

import com.ct.exceptions.GlobalExceptionController;
import com.ct.models.Quiz;
import com.ct.services.QuizServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;


public class QuizController extends Controller{

    private final QuizServiceImpl quizService;

    public QuizController(ObjectMapper objectMapper, GlobalExceptionController globalExceptionController) {
        super(objectMapper, globalExceptionController);
        this.quizService = new QuizServiceImpl();
    }

    public QuizController(QuizServiceImpl mockQuizService, ObjectMapper objectMapper, GlobalExceptionController globalExceptionController) {
        super(objectMapper, globalExceptionController);
        this.quizService = mockQuizService;
    }


    @Override
    protected void execute(HttpExchange exchange) throws Exception {
        System.out.println(exchange);
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");        switch(exchange.getRequestMethod()) {
            case "POST":
                createQuiz(exchange);
                break;
            case "GET":
                getAllQuizzes(exchange);
                break;
            case "OPTIONS":
                exchange.sendResponseHeaders(200, 0);
                break;
            default:
                throw new NoSuchMethodException("Method " + exchange.getRequestMethod() + " is not allowed for " + exchange.getRequestURI());
        }
    }

    private void createQuiz(HttpExchange exchange) throws SQLException, IOException {
        byte[] response = super.writeResponse(quizService.getAllQuizzes());
        exchange.sendResponseHeaders(200, response.length);
        OutputStream os = exchange.getResponseBody();
        os.write((response));
        os.flush();
        exchange.close();
    }

    private void getAllQuizzes(HttpExchange exchange) throws IOException, SQLException {
        byte[] response = super.writeResponse(quizService.getAllQuizzes());
        exchange.sendResponseHeaders(200, response.length);
        OutputStream os = exchange.getResponseBody();
        os.write((response));
        os.flush();
        exchange.close();
    }

    private void getQuizById(HttpExchange exchange) {

    }
}
