package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {


    public void saveUser(User user);

    public void deleteUser(Long id);


    public void updateUser(User user);

    public User findById(Long id);

    public List<User> getAllUsers();


}
