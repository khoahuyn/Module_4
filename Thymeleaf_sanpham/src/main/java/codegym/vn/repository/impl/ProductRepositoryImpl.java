package codegym.vn.repository.impl;

import codegym.vn.model.Product;
import codegym.vn.repository.CategoryRepository;
import codegym.vn.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private Map<Integer, Product> productMap = new HashMap<>();

    public ProductRepositoryImpl() {
        CategoryRepository categoryRepository = new CategoryRepositoryImpl();

        productMap.put(1, new Product(1, "Samsung S23", 15000000, "USA",categoryRepository.findById(2)));
        productMap.put(2, new Product(2, "Iphone 14",  19000000, "ITALY",categoryRepository.findById(2)));
        productMap.put(3, new Product(3, "Laptop lenovo legion", 20000000,"PERU" ,categoryRepository.findById(1)));
        productMap.put(4, new Product(4, "Laptop asus", 14000000,"AQUAMAN", categoryRepository.findById(1)));
    }

    @Override
    public boolean create(Product product) {
        if (productMap.containsKey(product.getId())) {
            return false;
        }

        productMap.put(product.getId(), product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        if (productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
            return true;
        }
        return false;
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public boolean deleteById(int id) {
        if (productMap.containsKey(id)) {
            productMap.remove(id);
            return true;
        }
        return false;
    }
}
