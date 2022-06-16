package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    User update(User user);
    List<User> findAll();
    User getById(long id);
    void detete(Long id);
}
