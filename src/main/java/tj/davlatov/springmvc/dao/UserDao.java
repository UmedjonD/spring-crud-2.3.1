package tj.davlatov.springmvc.dao;

import tj.davlatov.springmvc.models.User;

import java.util.List;

public interface UserDao {
    public List<User> getUsers();
    public User show(int id);
    public void save(User user);
    public void update(User updateUser);
    public void delete(int id);
}
