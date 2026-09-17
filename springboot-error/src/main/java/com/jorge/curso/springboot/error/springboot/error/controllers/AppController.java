package com.jorge.curso.springboot.error.springboot.error.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.curso.springboot.error.springboot.error.exceptions.UserNotFoundException;
import com.jorge.curso.springboot.error.springboot.error.models.domain.User;
import com.jorge.curso.springboot.error.springboot.error.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    private UserService service;

    public AppController(UserService userService) {
        this.service = userService;
    }

    @GetMapping
    public String index() {
        // int value = 100/0;
        int value = Integer.parseInt("10a");
        System.out.println(value);
        return "OK 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id) {
        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario no encontrado!!"));
        System.out.println(user.getLastname());
        return user;
    }

}
