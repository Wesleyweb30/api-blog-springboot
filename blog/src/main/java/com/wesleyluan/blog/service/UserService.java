package com.wesleyluan.blog.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wesleyluan.blog.domain.User;
import com.wesleyluan.blog.dto.UserDTO;
import com.wesleyluan.blog.dto.UserInsertDTO;
import com.wesleyluan.blog.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {

        List<User> listUser = userRepository.findAll();
        /*
         * Elemento por elemento da coleção é convertido de um tipo x para outro outro
         * Ex Atual : Retorno minha coleção listUser para um Objeto para TDO
         */
        return listUser.stream()
        .map(x -> new UserDTO(x))
        .collect(Collectors.toList());

    }

    public ResponseEntity<UserDTO> findById(Long id){
        Optional<User> userOpt = userRepository.findById(id);
        UserDTO userDto = new UserDTO(userOpt.get());
        return ResponseEntity.ok(userDto);
        }

    public ResponseEntity<UserDTO> save(UserInsertDTO dto) {

        User obj = new User();
        obj.setName(dto.getName());
        obj.setEmail(dto.getEmail());
        obj.setPassword(dto.getPassword());
        obj = userRepository.save(obj);
        UserDTO userDTO = new UserDTO();
        userDTO.setName(obj.getName());
        userDTO.setEmail(obj.getEmail());

        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    public ResponseEntity<UserDTO> update(Long id,UserDTO dto){
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User userObj = userOpt.get();
            userObj.setName(dto.getName());
            userObj.setEmail(dto.getEmail());
            userRepository.save(userObj);
            return ResponseEntity.ok(new UserDTO(userObj));    
        }
        return ResponseEntity.notFound().build();
    }
}
