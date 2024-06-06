package com.muratocal.exchange.services;

import java.util.List;

import com.muratocal.exchange.dtos.UserDTO;
import com.muratocal.exchange.models.User;

public interface UserService {

    User saveUser(UserDTO user);

    User getUserById(Long id);

    List<User> getUsers();
}
