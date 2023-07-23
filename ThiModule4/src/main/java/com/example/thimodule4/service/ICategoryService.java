package com.example.thimodule4.service;

import com.example.thimodule4.entity.Category;


import java.util.List;

public interface ICategoryService {
    void create(Category category);

    void update(Category category);

    List<Category> findAll();

    Category findById(Integer categoryId);

    void deleteById(Integer categoryId);
}
