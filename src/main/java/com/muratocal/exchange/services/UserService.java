package com.muratocal.exchange.services;

import java.util.List;

import com.muratocal.exchange.dtos.UserCreateDTO;
import com.muratocal.exchange.models.User;

public interface UserService {

    User saveUser(UserCreateDTO user);

    User getUserById(Long id);

    List<User> getUsers();
}
