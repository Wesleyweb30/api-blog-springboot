package com.wesleyluan.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleyluan.blog.domain.User;
import com.wesleyluan.blog.repository.UserRepository;
import com.wesleyluan.dto.UserDTO;

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

    public User save(User entity) {
        User user = userRepository.findByEmail(entity.getEmail());
        if (user != null) {
            return null;
        }
        return userRepository.save(entity);
    }
}
