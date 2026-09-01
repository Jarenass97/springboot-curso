package com.jorge.curso.springboot.webapp.springbootweb.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.curso.springboot.webapp.springbootweb.models.User;
import com.jorge.curso.springboot.webapp.springbootweb.models.dto.UserDTO;

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

    @RequestMapping(path = "/detailsDTO", method = RequestMethod.GET)
    public UserDTO detailsDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setTitle("Hola Mundo Spring Boot DTO");
        userDTO.setUser(new User("Jorge", "Arenas"));
        return userDTO;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<User> list() {
        List<User> users = new ArrayList<>();
        users.add(new User("Jorge", "Arenas"));
        users.add(new User("Juan", "Perez"));
        users.add(new User("Maria", "Gonzalez"));
        return users;
    }

}
