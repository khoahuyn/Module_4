package codegym.vn.service.impl;

import codegym.vn.model.Product;
import codegym.vn.repository.impl.ProductRepositoryImpl;
import codegym.vn.service.CategoryService;
import codegym.vn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepositoryImpl repository;
    @Override
    public boolean create(Product product) {
        return repository.create(product);
    }

    @Override
    public boolean update(Product product) {
       return repository.update(product);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }
}
