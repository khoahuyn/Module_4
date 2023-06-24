package codegym.vn.test.service;

import codegym.vn.test.model.User;
import codegym.vn.test.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository repository;

    @Override
    public void create(User user) {
        repository.save(user);

    }

    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }



}
