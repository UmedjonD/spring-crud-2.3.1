package tj.davlatov.springmvc.dao;

import org.springframework.stereotype.Component;
import tj.davlatov.springmvc.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Component
public class UserDaoImpl implements UserDao{

    private List<User> userList = null;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        Query query = entityManager.createQuery("From User");
        return userList = query.getResultList();
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
    public void update(int id, User updateUser) {
        User beUpdate = entityManager.find(User.class, id);
        beUpdate.setName(updateUser.getName());
        beUpdate.setLastname(updateUser.getLastname());
        beUpdate.setEmail(updateUser.getEmail());
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
