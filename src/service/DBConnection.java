package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;
    private static DBConnection dbConnection;
    private DBConnection(String username, String password){
        String url ="jdbc:mysql://localhost:3306/case_study_module3";
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static DBConnection getInstance(String username, String password){
        if (dbConnection==null){
            dbConnection=new DBConnection(username, password);
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
