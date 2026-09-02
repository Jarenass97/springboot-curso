package com.jorge.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import com.jorge.springboot.di.app.springbootdi.models.Product;

public class ProductRepository {

    List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria corsair 32", 100),
                new Product(2L, "CPU Intel i7", 200),
                new Product(3L, "Tarjeta gráfica RTX 3080", 490));
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        return data.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No existe el producto con id: " + id));
    }

}
