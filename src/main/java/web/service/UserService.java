package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> listAll();
    void saveUser(User user);
    void update(User user);
    User getById(long id);
    void delete(Long id);

}
