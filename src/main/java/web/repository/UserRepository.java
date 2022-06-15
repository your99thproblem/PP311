package web.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }

    public User update(User user) {
        return entityManager.merge(user);
    }
    public List<User> findAll() {

        return entityManager.createQuery("SELECT a FROM User a", User.class).getResultList();
    }

    public User getById(long id) {
        return entityManager.find(User.class, id);
    }
    public void detete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

}

