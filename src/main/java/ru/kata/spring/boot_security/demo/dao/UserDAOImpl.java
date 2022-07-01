package ru.kata.spring.boot_security.demo.dao;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("Select U from User U", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void updateUser(User user, int id) {
        entityManager.merge(user);
    }

    @Override
    public User findByUsername(String username) {
        Query query = entityManager.createQuery("select user from User user where user.username = :username",User.class);
        query.setParameter("username",username);
        return (User) query.getSingleResult();
    }
}