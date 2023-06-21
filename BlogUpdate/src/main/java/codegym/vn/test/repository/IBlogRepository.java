package codegym.vn.test.repository;



import codegym.vn.test.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from  Blog   where title like :title",nativeQuery = true)
    List<Blog> findAllByTitle(@Param("title") String title);

}
