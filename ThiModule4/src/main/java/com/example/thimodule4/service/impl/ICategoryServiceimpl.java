package com.example.thimodule4.service.impl;


import com.example.thimodule4.entity.Category;
import com.example.thimodule4.repository.ICategoryRepository;
import com.example.thimodule4.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICategoryServiceimpl implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public void create(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        if(iCategoryRepository.existsById(category.getCategoryId())){
            iCategoryRepository.save(category);
        }
    }

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }


    @Override
    public Category findById(Integer categoryId) {
        return iCategoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public void deleteById(Integer categoryId) {
        iCategoryRepository.deleteById(categoryId);
    }
}
