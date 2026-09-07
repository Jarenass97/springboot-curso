package com.jorge.springboot.di.app.springbootdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.jorge.springboot.di.app.springbootdi.repositories.IProductRepository;
import com.jorge.springboot.di.app.springbootdi.repositories.ProductJSONRepository;

@Configuration
public class AppConfig {

    @Value("classpath:json/product.json")
    Resource resource;

    @Bean("productsJson")
    IProductRepository productRepositoryJson() {
        return new ProductJSONRepository(resource);
    }

}
