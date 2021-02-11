package tj.davlatov.springmvc.dao;

import org.springframework.stereotype.Component;
import tj.davlatov.springmvc.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Component
public class UserDaoImpl implements UserDao{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        Query query = entityManager.createQuery("From User");
        return query.getResultList();
    }

    @Override
    public User show(int id) {
//        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User updateUser) {
        User beUpdate = entityManager.merge(updateUser);
        beUpdate.setName(updateUser.getName());
        beUpdate.setLastname(updateUser.getLastname());
        beUpdate.setEmail(updateUser.getEmail());
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
