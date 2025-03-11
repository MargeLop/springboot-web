package com.marge.curso.springboot.webapp.springboot_web.models;

public class User {

    private String name;
    private String lastname;
    private String ocupation;
    private String email;

    public User() {
    }

    public User(String name, String lastname) {
        this(name, lastname, "Unemployed");
    }

    public User(String name, String lastname, String ocupation) {
        this.name = name;
        this.lastname = lastname;
        this.ocupation = ocupation;
    }

    public User(String name, String lastname, String ocupation, String email) {
        this(name, lastname, ocupation);
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getOcupation() {
        return ocupation;
    }
    public void setOcupation(String str) {
        this.ocupation = str;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
