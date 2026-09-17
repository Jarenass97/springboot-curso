package com.jorge.curso.springboot.error.springboot.error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jorge.curso.springboot.error.springboot.error.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null));
    }

}
