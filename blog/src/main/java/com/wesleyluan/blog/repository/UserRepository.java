package com.wesleyluan.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesleyluan.blog.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByEmail(String email);
} 
