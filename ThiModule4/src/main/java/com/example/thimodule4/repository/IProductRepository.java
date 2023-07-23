package com.example.thimodule4.repository;

import com.example.thimodule4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from Product where name like :name", nativeQuery = true)
    List<Product> findAllByName(@Param("name") String name);


    @Query(value = "select * from Product where price = :price", nativeQuery = true)
    List<Product> findAllByPrice(@Param("price") double price);



    @Query(value = "select * from Product where category_Id = :categoryId", nativeQuery = true)
    List<Product> findAllByCategory(@Param("categoryId") Integer categoryId);

}