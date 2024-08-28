package com.example.NewShop.Service.Interface;

import com.example.NewShop.model.User;
import com.example.NewShop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(long userId);
    List<User> getAllUsers();
    User updateUser(long userId, User user);
    void deleteUser(long userId);

}
