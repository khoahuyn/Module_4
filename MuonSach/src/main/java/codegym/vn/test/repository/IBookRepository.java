package codegym.vn.test.repository;



import codegym.vn.test.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select * from  Book   where name like :name",nativeQuery = true)
    List<Book> findAllByName(@Param("name") String name);

}
