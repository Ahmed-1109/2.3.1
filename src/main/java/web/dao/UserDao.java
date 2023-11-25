package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();

    void addUser(User user);

    User getUserById(int id);

    void delete(int id);

}
