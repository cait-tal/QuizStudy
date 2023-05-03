package com.ct.exceptions;

import com.ct.models.ErrorResponse;
import com.ct.utility.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class GlobalExceptionController {

    private final ObjectMapper objectMapper;

    public GlobalExceptionController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void handle(Throwable throwable, HttpExchange exchange) {
        try {
            throwable.printStackTrace();
            exchange.getResponseHeaders().set(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON);
            ErrorResponse response = getErrorResponse(throwable, exchange);
            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(objectMapper.writeValueAsBytes(response));
            responseBody.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ErrorResponse getErrorResponse(Throwable throwable, HttpExchange exchange) throws IOException {
        ErrorResponse errorResponse;

        if(throwable instanceof InvalidQuestionFormatException) {
            InvalidQuestionFormatException exc = (InvalidQuestionFormatException) throwable;
            errorResponse = new ErrorResponse(1, exc.getMessage());
            exchange.sendResponseHeaders(400, 0);
        } else {
            errorResponse = new ErrorResponse(500, throwable.getMessage());
            exchange.sendResponseHeaders(500, 0);
        }

        return errorResponse;
    }
}
