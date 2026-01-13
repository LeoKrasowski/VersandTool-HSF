package com.hsf.service;

import com.hsf.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deactivateUser(Long id, User user);
}
