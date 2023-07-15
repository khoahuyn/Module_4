package src.service;

import src.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IProductService {
    void create(Product product);

    void update(Product product);

    List<Product>findAll();

    List<Product>findAllByName(String name);

    Product findById(Integer productId);

    void deleteById(Integer productId);

    Page<Product>findWithByPaging(Pageable pageable);


}
