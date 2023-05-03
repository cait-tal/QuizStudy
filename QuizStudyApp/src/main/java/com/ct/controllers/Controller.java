package com.ct.controllers;

import com.ct.exceptions.GlobalExceptionController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;

public abstract class Controller {
    private final ObjectMapper objectMapper;
    private final GlobalExceptionController exceptionController;

    public Controller(ObjectMapper objectMapper, GlobalExceptionController exceptionController) {
        this.objectMapper = objectMapper;
        this.exceptionController = exceptionController;
    }

    public void handle(HttpExchange exchange) {
        try {
            execute(exchange);
        } catch (Exception e) {
            exceptionController.handle(e, exchange);
        }
    }

    protected abstract void execute(HttpExchange exchange) throws Exception;

    protected <T> T readRequest(InputStream is, Class<T> type) throws IOException {
        return objectMapper.readValue(is, type);
    }

    protected <T> byte[] writeResponse(T response) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(response);
    }

    protected static Headers getHeaders(String key, String value) {
        Headers headers = new Headers();
        headers.set(key, value);
        return headers;
    }
}
