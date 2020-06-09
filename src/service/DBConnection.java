package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection connection;
    private static DBConnection dbConnection;
    private DBConnection(){
        String url ="jdbc:mysql://localhost:3306/..";
        String userName ="mystery1309";
        String password = "13091997";
        try {
            this.connection = DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance(){
        if (dbConnection==null){
            dbConnection=new DBConnection();

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
