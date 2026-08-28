package com.jorge.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.curso.springboot.webapp.springbootweb.models.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @RequestMapping(path = "/details", method = RequestMethod.GET)
    public Map<String, Object> details() {
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", new User("Jorge", "Arenas"));

        return body;
    }
}
