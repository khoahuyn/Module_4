package codegym.vn.test.service;



import codegym.vn.test.model.Category;
import codegym.vn.test.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements ICategoryService {

    @Autowired
    ICategoryRepository repository;

    @Override
    public void create(Category category) {
        repository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return  repository.findAll();
    }

    @Override
    public Category findById(Integer categoryId) {
        return repository.findById(categoryId).orElse(null);
    }

    @Override
    public void update(Category category) {
        if (repository.existsById(category.getCategoryId())){
            repository.save(category);
        }
    }


}
