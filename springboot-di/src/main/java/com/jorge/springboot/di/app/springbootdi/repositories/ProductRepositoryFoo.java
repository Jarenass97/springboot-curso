package com.jorge.springboot.di.app.springbootdi.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jorge.springboot.di.app.springbootdi.models.Product;

@Repository("productFoo")
public class ProductRepositoryFoo implements IProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor Asus 27", 600));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor Asus 27", 600);
    }

}
