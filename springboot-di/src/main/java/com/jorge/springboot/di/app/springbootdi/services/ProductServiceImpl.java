package com.jorge.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.jorge.springboot.di.app.springbootdi.models.Product;
import com.jorge.springboot.di.app.springbootdi.repositories.IProductRepository;

@Service
@PropertySource("classpath:config.properties")
public class ProductServiceImpl implements IProductService {

    private IProductRepository repository;

    private final Environment env;

    public ProductServiceImpl(@Qualifier("productsJson") IProductRepository repository, Environment env) {
        this.repository = repository;
        this.env = env;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double price = p.getPrice() * env.getProperty("product.tax", Double.class);
            // p.setPrice(price.longValue());
            // return p;
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
