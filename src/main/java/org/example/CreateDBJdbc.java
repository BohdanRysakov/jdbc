package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDBJdbc {
    static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String JDBC_DRIVER = "org.postgresql.Driver";

    static final String USER = "postgres";
    static final String PASSWORD = "root";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            System.out.println("Registering JDBC driver...");
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to DB...");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            System.out.println("Creating database...");
            statement = connection.createStatement();

            String SQL = "CREATE DATABASE learningDB";
            statement.executeUpdate(SQL);
            System.out.println("Database successfully created...");

        }
        finally {
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
    }
}