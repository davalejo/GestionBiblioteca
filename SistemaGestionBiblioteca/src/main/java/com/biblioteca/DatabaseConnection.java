package com.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "nuevo_usuario"; // Cambia por tu usuario
    private static final String PASSWORD = "nueva_contraseña"; // Cambia por tu contraseña

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}