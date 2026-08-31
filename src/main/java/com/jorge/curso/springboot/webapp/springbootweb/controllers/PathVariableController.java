package com.jorge.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.curso.springboot.webapp.springbootweb.models.User;
import com.jorge.curso.springboot.webapp.springbootweb.models.dto.ParamDto;



@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;
    // @Value("${config.message}")
    // private String message;
    @Value("${config.listofnames}")
    private String[] listOfNames;
    @Value("${config.code}")
    private Integer code;

    @RequestMapping(path = "/baz/{message}", method = RequestMethod.GET)
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @RequestMapping(path = "/mix/{product}/{id}", method = RequestMethod.GET)
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @RequestMapping(path = "/create", method=RequestMethod.POST)
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        return user;
    }
    
    @RequestMapping(path = "/values", method=RequestMethod.GET)
    public Map<String, Object> values(@Value("${config.message}") String message) {
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("listOfNames", listOfNames);
        json.put("code", code);
        return json;
    }
    
}
