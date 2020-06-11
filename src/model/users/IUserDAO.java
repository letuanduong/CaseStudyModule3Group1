package model.users;

import java.util.List;

public interface IUserDAO {
    public User getByUsername(String username);
    public void deleteByUsername(String username);
    public void updateUser(String username, String password, int role);
    public List<User> getAllUsers();
}
