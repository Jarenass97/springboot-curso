package com.jorge.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jorge.springboot.di.app.springbootdi.models.Product;
import com.jorge.springboot.di.app.springbootdi.repositories.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

    private IProductRepository repository;

    public ProductServiceImpl(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double price = p.getPrice() * 1.25d;
            Product product = p.clone();
            product.setPrice(price.longValue());
            return product;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
