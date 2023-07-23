package com.example.thimodule4.service.impl;


import com.example.thimodule4.entity.Product;
import com.example.thimodule4.repository.IProductRepository;
import com.example.thimodule4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProductServiceimpl implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public void create(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void update(Product product) {
        if(iProductRepository.existsById(product.getProductId())){
            iProductRepository.save(product);
        }
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public List<Product> findAllByName(String name) {
        return iProductRepository.findAllByName("%"+name+"%");
    }

    @Override
    public List<Product> findProductByPrice(double price) {
       return iProductRepository.findAllByPrice(price);
    }

    @Override
    public List<Product> findProductByCategory(Integer categoryId) {
        return iProductRepository.findAllByCategory(categoryId);
    }


    @Override
    public Product findById(Integer productId) {
        return iProductRepository.findById(productId).orElse(null);
    }

    @Override
    public void deleteById(Integer productId) {
        iProductRepository.deleteById(productId);
    }

    @Override
    public Page<Product> findWithByPaging(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }


}
