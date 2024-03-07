package com.wesleyluan.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesleyluan.blog.domain.Post;
import com.wesleyluan.blog.dto.PostInsertDTO;
import com.wesleyluan.blog.service.PostService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody PostInsertDTO dto) {
        return postService.save(dto);
    }
    
}
