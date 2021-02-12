package tj.davlatov.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tj.davlatov.springmvc.dao.UserDao;
import tj.davlatov.springmvc.dao.UserDaoImpl;
import tj.davlatov.springmvc.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User find(int id) {
        return userDao.find(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(int id, User updateUser) {
        userDao.update(updateUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
