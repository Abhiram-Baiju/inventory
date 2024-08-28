package com.example.NewShop.controller;

import com.example.NewShop.Service.Interface.UserService;
import com.example.NewShop.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping(path = "/user")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping(path = "/user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") long userId, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(userId, user));
    }

    @DeleteMapping(path = "/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}
