package com.wesleyluan.blog.dto;

import com.wesleyluan.blog.domain.User;

public class UserDTO {
    private Long id;
    private String name;
    private String email;

    public UserDTO(){

    }
    public UserDTO(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDTO(User entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}

