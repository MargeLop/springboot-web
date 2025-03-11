package com.marge.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marge.curso.springboot.webapp.springboot_web.models.User;
import com.marge.curso.springboot.webapp.springboot_web.models.dto.UserDto;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details(){
        UserDto userDto = new UserDto();
        User user = new User("Marga", "López");
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot");
        return userDto;

    }

    @GetMapping("/list")
    public List<User> list(){
        User user = new User("Marga", "López", "administrator");
        User user2 = new User("Pepe", "Pérez", "developer");
        User user3 = new User("John", "Doe", "designer");

        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        List<User> users = Arrays.asList(user, user2, user3);
        return users;
    }

    @GetMapping("/details-map")
    public Map<String, Object> detailsmap(){
        User user = new User("Marga", "López");
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user.getName().concat(" ").concat(user.getLastname()));
        body.put("date", new Date());
        return body;

    }    

    @GetMapping("/details2") // @RequestMapping(path = "/details", method = RequestMethod.GET)
    public Map<String, Object> details2(){
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hola Mundo Spring Boot");
        body.put("name", "Marga");
        body.put("lastname", "López");
        body.put("date", new Date());
        return body;

    }
}