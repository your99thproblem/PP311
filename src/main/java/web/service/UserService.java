package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    @Transactional
    public List<User> listAll() {
        return repository.findAll();
    }

    @Transactional
    public void saveUser(User user) {
        repository.save(user);
    }

    @Transactional
    public void update(User user) {
        repository.update(user);
    }

    @Transactional
    public User getById(long id) {
        return repository.getById(id);
    }

    @Transactional
    public void delete(Long id) {
        repository.detete(id);
    }
}