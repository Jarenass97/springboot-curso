package com.jorge.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.jorge.springboot.di.app.springbootdi.models.Product;
import com.jorge.springboot.di.app.springbootdi.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double price = p.getPrice() * 1.25d;
            Product product = p.clone();
            product.setPrice(price.longValue());
            return product;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
}
