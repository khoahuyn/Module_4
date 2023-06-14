package test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.model.Blog;
import test.repository.IBlogRepository;

import java.util.List;


@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository repository;

    @Override
    public void create(Blog blog) {
        repository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) repository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        if (repository.existsById(blog.getId())){
            repository.save(blog);
        }
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
