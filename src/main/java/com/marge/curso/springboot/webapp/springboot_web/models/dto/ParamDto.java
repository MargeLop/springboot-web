package com.marge.curso.springboot.webapp.springboot_web.models.dto;

public class ParamDto {

    private Integer id;
    private String message;

    public ParamDto(){
        this.id = null;
        this.message = null;
    }

    public ParamDto(Integer ID, String message){
        this.id = ID;
        this.message = message;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
