package com.wesleyluan.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesleyluan.blog.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}
