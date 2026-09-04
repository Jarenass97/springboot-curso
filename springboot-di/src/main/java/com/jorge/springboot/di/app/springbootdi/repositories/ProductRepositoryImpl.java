package com.jorge.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jorge.springboot.di.app.springbootdi.models.Product;

@Repository
public class ProductRepositoryImpl implements IProductRepository{

    List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria corsair 32", 100),
                new Product(2L, "CPU Intel i7", 200),
                new Product(3L, "Tarjeta gráfica RTX 3080", 490));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No existe el producto con id: " + id));
    }

}
