package codegym.vn.test.service;


import codegym.vn.test.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IBlogService {
    void create(Blog blog);
    List<Blog> findAll();
    Blog findById(Integer id);
    void update(Blog blog);
    void deleteById(Integer id);
    List<Blog> findBlogByTitle(String title);

    Page<Blog> findAllWithPaging(Pageable pageable);
    Slice<Blog> findAllWithSlice(Pageable pageable);
}
