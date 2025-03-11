package com.marge.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.marge.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Marga", "López");
        user.setEmail("user@gmail.com");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model){

        model.addAttribute("title", "Listado de usuarios");
        // model.addAttribute("users", users);
        return "list";
    }

    @ModelAttribute("users") // Para pasar datos comunes a varias vistas sin tener que modificarlas
    public List<User> usersModel(){
        List<User> users = Arrays.asList(
            new User("Pepa", "González"),
            new User ("Lucía", "Martínez", "", "luciamartinez@gmail.com"),
            new User("Lalo", "Pérez"),
            new User ("Marta", "Sánchez", "", "martasanchez@correo.es")
        );
        return users;
    }


    @GetMapping("/mapdetails")
    public Map<String, Object> mapdetails(){
        Map<String, Object> model = new HashMap<>();
        User user = new User("Marga", "López");
        model.put("title", "Hola Mundo Spring Boot");
        model.put("user", user);
        model.put("date", new Date());
        return model;

    }

}
