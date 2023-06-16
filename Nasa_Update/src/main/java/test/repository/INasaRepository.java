package test.repository;




import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import test.model.Nasa;

import java.util.List;

public interface INasaRepository extends CrudRepository<Nasa,Integer> {
    @Query(value = "select c from Nasa c where c.date= :date")
    List<Nasa> findAllToday(@Param("date") String date);
}
