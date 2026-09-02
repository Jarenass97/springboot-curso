package com.jorge.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(path = { "", "/", "/home" }, method = RequestMethod.GET)
    public String home() {
        // return "redirect:/details";
        return "forward:/details";
    }

}
