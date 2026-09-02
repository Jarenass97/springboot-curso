package com.jorge.springboot.di.app.springbootdi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.springboot.di.app.springbootdi.models.Product;
import com.jorge.springboot.di.app.springbootdi.services.ProductService;

@RestController
@RequestMapping("/api")
public class SomeController {

    private ProductService service = new ProductService();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return service.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
