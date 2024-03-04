package com.wesleyluan.blog.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wesleyluan.blog.domain.User;
import com.wesleyluan.blog.dto.UserDTO;
import com.wesleyluan.blog.dto.UserInsertDTO;
import com.wesleyluan.blog.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> list = userService.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public UserDTO save(@RequestBody UserInsertDTO dto) {
       UserDTO obj = userService.save(dto);
       return obj;
    }
    
    
}
