package codegym.vn.test.repository;




import codegym.vn.test.model.Nasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface INasaRepository extends JpaRepository<Nasa,Integer> {
    @Query(value = "select c from Nasa c where c.date= :date")
    List<Nasa> findAllToday(@Param("date") String date);
}
