package src.repository;

import src.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select * from Product where name like :name",nativeQuery = true)
    List<Product>findAllByName(@Param("name")String name);


}
