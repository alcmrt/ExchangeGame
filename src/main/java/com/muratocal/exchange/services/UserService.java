package com.muratocal.exchange.services;

import com.muratocal.exchange.models.User;

public interface UserService {

    User saveUser(User user);

    User getUserById(Long id);
}
