package codegym.vn.service.impl;

import codegym.vn.model.Category;
import codegym.vn.repository.impl.CategoryRepositoryImpl;
import codegym.vn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepositoryImpl repository;
    @Override
    public boolean create(Category category) {
        return repository.create(category);
    }

    @Override
    public boolean update(Category category) {
        return repository.update(category);
    }

    @Override
    public Category findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }
}
