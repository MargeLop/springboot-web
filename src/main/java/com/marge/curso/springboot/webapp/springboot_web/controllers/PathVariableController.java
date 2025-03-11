package com.marge.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marge.curso.springboot.webapp.springboot_web.models.User;
import com.marge.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.code}")
    private Integer code;
    @Value("${config.username}")
    private String username;
    @Value("${config.listOfValues}")
    private List<String> listOfValues; // String[] listOfValues;

    @Value("#{ '${config.listOfValues}'.toUpperCase().split(',') }")
    private List<String> valueList;

    @Value("#{ '${config.listOfValues}'.toUpperCase() }")
    private String valueStr;

    @Value("#{ ${config.valuesMap} }")
    private Map<String, Object> valuesMap;

    @Value("#{ ${config.valuesMap}.product }")
    private String product;

    @Value("#{ ${config.valuesMap}.price }")
    private float price;

    @Autowired
    private Environment environment;

    @GetMapping("/buzz/{message}") // http://localhost:8080/api/var/buzz/hola a todos
    public ParamDto buzz(@PathVariable String message) { // @PathVariable(name="message") String messageOtro
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
  
    @GetMapping("/mix/{product}/{id}") // http://localhost:8080/api/var/mix/teclado/123
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }
    
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        
        return user;
    }
    
    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String message) {
        Map<String, Object> json = new HashMap<>();
        json.put("username", this.username);
        json.put("code", this.code);
        json.put("code2", Integer.valueOf(environment.getProperty("config.code")));
        json.put("code3", environment.getProperty("config.code", Integer.class));
        json.put("listOfValues", this.listOfValues);
        json.put("listOfValues2", environment.getProperty("config.listOfValues"));
        json.put("valueList", valueList);
        json.put("valueStr", valueStr);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        return json;
    }
    
}
