package codegym.vn.test.service;


import codegym.vn.test.model.User;


import java.util.List;

public interface IUserService {
    void create(User user);
    List<User> findAll();

}
