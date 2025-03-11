package com.marge.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marge.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola que tal", name = "mensaje") String message) {
        ParamDto dto = new ParamDto();
        dto.setMessage(message); // message != null ? message : "Hola que tal");
        return dto;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam(required = false) String message, 
                        @RequestParam(required = false) Integer id) {
        ParamDto dto = new ParamDto(id, message);
        return dto;
    }
 
    @GetMapping("/request")
    public ParamDto request(HttpServletRequest request) {
        Integer intCode = 0;
        try {
            intCode = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            intCode = 999;
        }
        ParamDto params = new ParamDto();
        params.setId(intCode);
        params.setMessage(request.getParameter("message"));
        return params;
    }    

}
