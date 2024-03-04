package com.wesleyluan.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleyluan.blog.domain.User;
import com.wesleyluan.blog.dto.UserDTO;
import com.wesleyluan.blog.dto.UserInsertDTO;
import com.wesleyluan.blog.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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

    public UserDTO save(UserInsertDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail());
        if (user != null) {
            return null;
        }

        User obj = new User();
        obj.setName(dto.getName());
        obj.setEmail(dto.getEmail());
        obj.setPassword(dto.getPassword());
        obj = userRepository.save(obj);

        return new UserDTO(obj);
    }
}
