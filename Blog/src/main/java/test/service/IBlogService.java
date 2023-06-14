package test.service;




import test.model.Blog;

import java.util.List;

public interface IBlogService {
    void create(Blog blog);
    List<Blog> findAll();
    Blog findById(Integer id);
    void update(Blog blog);
    void deleteById(Integer id);
}
