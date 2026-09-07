package com.jorge.springboot.di.app.springbootdi.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.jorge.springboot.di.app.springbootdi.models.Product;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

public class ProductJSONRepository implements IProductRepository {

    private List<Product> products;

    public ProductJSONRepository() {
        Resource resource = new ClassPathResource("json/product.json");
        readValueFromJson(resource);
    }

    public ProductJSONRepository(Resource resource) {
        readValueFromJson(resource);
    }

    private void readValueFromJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            products = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (JacksonException | IOException e) {
            products = List.of(); // Initialize with an empty list in case of an error
        }
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
