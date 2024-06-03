package com.muratocal.exchange.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.muratocal.exchange.models.User;
import com.muratocal.exchange.repositories.UserRepository;
import com.muratocal.exchange.services.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

}
