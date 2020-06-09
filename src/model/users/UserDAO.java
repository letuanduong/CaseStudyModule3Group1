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
        List<User> users = new ArrayList();
        public UserDAO(DBConnection connection) {
            this.connection = connection;
        }

        public User getByUsername(String username) {
            String sql = "SELECT username, password, role FROM users WHERE username = ?";

            try {
                PreparedStatement statement = this.connection.getConnection().prepareStatement(sql);
                statement.setString(1, username);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String uname = resultSet.getString(1);
                    String pass = resultSet.getString(2);
                    int role = resultSet.getInt(3);
                    return new User(uname, pass, role);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

    @Override
    public void deleteByUsername(String username) {

    }

    @Override
    public List<User> getUsers() {
        String sql = "INSERT INTO users(USERNAME, PASSWORD, ROLE) VALUES (?, ?, ?)";
        try {
            Statement statement = this.connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            String name = resultSet.getString(1);
            String pass = resultSet.getString(2);
            int role = resultSet.getInt(3);
            User user = new User(name, pass, role);
            users.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}

