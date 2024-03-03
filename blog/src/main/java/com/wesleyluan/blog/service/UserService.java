package com.wesleyluan.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleyluan.blog.domain.User;
import com.wesleyluan.blog.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User save(User entity){
        User user = userRepository.findByEmail(entity.getEmail());
        if (user != null) {
            return null;
        }
        return userRepository.save(entity);
    }
}
