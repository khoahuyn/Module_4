package codegym.vn.test.service;


import codegym.vn.test.model.Blog;
import codegym.vn.test.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Blog> findBlogByTitle(String title) {
        return repository.findAllByTitle("%"+ title+"%");
    }



    @Override
    public Page<Blog> findAllWithPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Slice<Blog> findAllWithSlice(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
