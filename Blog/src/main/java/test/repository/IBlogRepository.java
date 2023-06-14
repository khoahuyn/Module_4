package test.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.model.Blog;

@Repository
public interface IBlogRepository extends CrudRepository<Blog,Integer>{

}
