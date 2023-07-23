package com.example.thimodule4.service;


import com.example.thimodule4.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    void create(Product product);

    void update(Product product);

    List<Product> findAll();

    List<Product>findAllByName(String name);


    List<Product> findProductByPrice(double price);


    List<Product> findProductByCategory(Integer categoryId);


    Product findById(Integer productId);

    void deleteById(Integer productId);

    Page<Product> findWithByPaging(Pageable pageable);


}
