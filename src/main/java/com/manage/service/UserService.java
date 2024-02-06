package com.manage.service;
import java.util.List;
import java.util.Optional;

import com.manage.model.User;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserById(int id);
    User updateUser(int id, User updatedUser);
    String deleteUserById(int id);
    List<User> getAllUsers();
}
