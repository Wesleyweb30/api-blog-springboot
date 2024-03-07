package com.wesleyluan.blog.dto;

import com.wesleyluan.blog.domain.Post;
import com.wesleyluan.blog.domain.User;

public class PostInsertDTO {
    private String title;
    private String text;
    private boolean status;
    private User user;

    public PostInsertDTO(String title, String text, boolean status, User user){
        this.title = title;
        this.text = text;
        this.status = status;
        this.user = user;
    }
    public PostInsertDTO(){

    }
    public PostInsertDTO(Post entity){
        this.title = entity.getTitle();
        this.text = entity.getText();
        this.status = entity.isStatus();
        this.user = entity.getUser();
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
}
