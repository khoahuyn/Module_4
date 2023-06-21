package codegym.vn.test.service;



import codegym.vn.test.model.Category;

import java.util.List;

public interface ICategoryService {
    void create(Category category);
    List<Category> findAll();
    Category findById(Integer categoryId);
    void update(Category category);


}
