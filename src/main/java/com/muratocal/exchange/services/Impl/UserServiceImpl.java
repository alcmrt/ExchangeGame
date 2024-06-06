package com.muratocal.exchange.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratocal.exchange.dtos.UserDTO;
import com.muratocal.exchange.models.User;
import com.muratocal.exchange.repositories.UserRepository;
import com.muratocal.exchange.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());

        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
