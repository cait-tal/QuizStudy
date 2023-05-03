package com.ct.main;


import com.ct.controllers.QuizController;
import com.ct.utility.Configuration;
import com.ct.utility.Constants;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Driver extends Configuration {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(Constants.SERVER_PORT), 0);
        QuizController quizController = new QuizController(getQuizService(), getObjectMapper(), getGlobalExceptionController());
        server.createContext("/api/quizzes", quizController::handle);

        server.createContext("/api/hello", (exchange -> {
            String respText = "Hello!";
            exchange.sendResponseHeaders(200, respText.getBytes().length);
            OutputStream output = exchange.getResponseBody();
            output.write(respText.getBytes());
            output.flush();
            exchange.close();
        }));
        server.setExecutor(null);
        server.start();
    }

}
