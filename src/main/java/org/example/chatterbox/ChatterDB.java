package org.example.chatterbox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ChatterDB {
    public static final String SERVER_ADDRESS = "192.168.0.110";
    public static final int SERVER_PORT = 3306;
    private static final String DATABASE_NAME = "ChatterBox";
    private static final String USERNAME = "ChatterBoxApp";
    private static final String PASSWORD = "ChatterBoxApplication@2024";

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s", SERVER_ADDRESS, SERVER_PORT, DATABASE_NAME);
        return DriverManager.getConnection(url, USERNAME, PASSWORD);
    }
}
