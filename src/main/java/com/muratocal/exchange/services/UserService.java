package com.muratocal.exchange.services;

import com.muratocal.exchange.models.User;

public interface UserService {

    User savUser(User user);

    User getUserById(Long id);
}
