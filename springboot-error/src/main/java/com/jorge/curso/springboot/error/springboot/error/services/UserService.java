package com.jorge.curso.springboot.error.springboot.error.services;

import java.util.List;
import java.util.Optional;

import com.jorge.curso.springboot.error.springboot.error.models.domain.User;

public interface UserService {

    List<User> findAll();
    Optional<User> findById(Long id);
}
