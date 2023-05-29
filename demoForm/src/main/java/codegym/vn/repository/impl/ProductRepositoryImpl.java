package codegym.vn.repository.impl;

import codegym.vn.entity.Product;
import codegym.vn.repository.CategoryRepository;
import codegym.vn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private Map<Integer, Product> productMap = new HashMap<>();

    public ProductRepositoryImpl() {
        CategoryRepository categoryRepository = new CategoryRepositoryImpl();
        Date date = null;
        try {
            date = (new SimpleDateFormat("dd/MM/yyyy")).parse("01/01/2023");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        productMap.put(1, new Product(1, "Samsung S23", 5, date, 15000000, categoryRepository.findById(2)));
        productMap.put(2, new Product(2, "Iphone 14", 7, date, 19000000, categoryRepository.findById(2)));
        productMap.put(3, new Product(3, "Laptop lenovo legion", 2, date, 20000000, categoryRepository.findById(1)));
        productMap.put(4, new Product(4, "Laptop asus", 10, date, 14000000, categoryRepository.findById(1)));
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
