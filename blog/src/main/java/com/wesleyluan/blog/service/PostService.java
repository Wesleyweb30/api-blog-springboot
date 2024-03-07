package com.wesleyluan.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.wesleyluan.blog.domain.Post;
import com.wesleyluan.blog.dto.PostInsertDTO;
import com.wesleyluan.blog.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public ResponseEntity<Post> save(PostInsertDTO dto){
        Post postObj = new Post();
        postObj.setTitle(dto.getTitle());
        postObj.setText(dto.getText());
        postObj.setStatus(dto.isStatus());
        postObj.setUser(dto.getUser());
        postRepository.save(postObj);
        return new ResponseEntity<Post>(postObj, HttpStatus.CREATED);
    }
}
