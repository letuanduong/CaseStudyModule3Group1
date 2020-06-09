package model.users;

import service.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{

        DBConnection connection;

        public UserDAO(DBConnection connection) {
            this.connection = connection;
        }
//############################################################################
        public List<User> getByUsername(String _username) {
            List<User> ListUser = new ArrayList();
            String sql = "SELECT password, role FROM users WHERE username = ?";
            try {
                PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, _username);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String pass = resultSet.getString(2);
                    int role = resultSet.getInt(3);
                    User user = new User(_username, pass, role);
                    ListUser.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
//                throw new RuntimeException("Error Systax function SQL");
            }
            return ListUser;
        }

    @Override
    public void deleteByUsername(String username) {
        String sql = "delete from users where username = ?";
        try {
            PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error Systax function SQL");
        }
    }

    @Override
    public void Save(String username, String password, int role) {
        String sql = "INSERT INTO users(USERNAME, PASSWORD, ROLE) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement  = this.connection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, role);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> ListUser = new ArrayList();
        String sql = "select *from users;";
        try {
            Statement statement = this.connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String name = resultSet.getString(1);
                String pass = resultSet.getString(2);
                int role = resultSet.getInt(3);
                User user = new User(name, pass, role);
                ListUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error Systax function SQL");
        }
        return ListUser;
    }
}

