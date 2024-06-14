package com.muratocal.exchange.controllers.v1;

import org.springframework.web.bind.annotation.RestController;

//import com.muratocal.exchange.models.AppUser;
import com.muratocal.exchange.models.User;
import com.fasterxml.jackson.annotation.JsonView;
import com.muratocal.exchange.dtos.UserCreateDTO;
import com.muratocal.exchange.dtos.UserDTO;
import com.muratocal.exchange.mappers.UserMapper;
import com.muratocal.exchange.services.UserService;
import com.muratocal.exchange.views.View;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "User operations")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCreateDTO user) {

        User createdUser = userService.saveUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {

        try {
            User user = userService.getUserById(id);
            return ResponseEntity.ok(userMapper.toUserDTO(user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(userMapper.toUserDTOList(users));
    }
}
