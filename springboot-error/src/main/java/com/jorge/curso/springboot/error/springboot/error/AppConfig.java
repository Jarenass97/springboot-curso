package com.jorge.curso.springboot.error.springboot.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jorge.curso.springboot.error.springboot.error.models.domain.Role;
import com.jorge.curso.springboot.error.springboot.error.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "jorge", "arenas", new Role("admin")));
        users.add(new User(2L, "juan", "perez"));
        users.add(new User(3L, "maria", "perez", new Role("user")));
        users.add(new User(4L, "pedro", "perez"));
        users.add(new User(5L, "carlos", "perez"));
        return users;
    }
}
