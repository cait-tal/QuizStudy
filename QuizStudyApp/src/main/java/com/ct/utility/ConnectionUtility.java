package com.ct.utility;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

    private ConnectionUtility() {}

    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new SQLServerDriver());

        String url = System.getenv("db_url");
        String username = System.getenv("db_username");
        String password = System.getenv("db_password");


        return DriverManager.getConnection(url, username, password);
    }
}
