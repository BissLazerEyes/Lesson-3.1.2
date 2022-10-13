package web.Lesson312.dao;

import web.Lesson312.model.User;
import java.util.List;

public interface UserDao {

    List<User>getAllUsers ();
    User getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user);
    User getUserByLogin(String username);
}