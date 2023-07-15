package src.service.impl;

import src.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import src.repository.IProductRepository;
import src.service.IProductService;

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
