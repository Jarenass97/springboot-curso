package com.jorge.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @RequestMapping(path = "/foo", method = RequestMethod.GET)
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Sin mensaje", name = "msg") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @RequestMapping(path = "/bar", method = RequestMethod.GET)
    public ParamDto bar(@RequestParam String text, @RequestParam Integer code) {
        ParamDto params = new ParamDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @RequestMapping(path = "/request", method=RequestMethod.GET)
    public ParamDto request(HttpServletRequest request) {
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
        }
        ParamDto param = new ParamDto();
        param.setMessage(request.getParameter("message"));
        param.setCode(code);
        return param;
    }
    
}
