package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;
    private static DBConnection dbConnection;
    private DBConnection(String username, String password) throws ClassNotFoundException {
        String url ="jdbc:mysql://localhost:3306/case_study_module3";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("no connect: false");
        }
    }
    public static DBConnection getInstance(String username, String password) throws ClassNotFoundException {
        if (dbConnection==null){
            dbConnection = new DBConnection(username, password);
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return this.connection;
    }

    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
