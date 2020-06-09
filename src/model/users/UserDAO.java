package model.users;


import service.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
        DBConnection connection;

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
}

