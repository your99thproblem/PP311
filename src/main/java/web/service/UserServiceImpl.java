package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    UserDao userDao;

    @Transactional
    public List<User> listAll() {
        return userDao.findAll();
    }

    @Transactional
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Transactional
    public void delete(Long id) {
        userDao.detete(id);
    }
}