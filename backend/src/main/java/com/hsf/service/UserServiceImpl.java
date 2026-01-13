package com.hsf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsf.entity.User;
import com.hsf.repository.UserRepository;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    // Implementation of UserService methods would go here
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User updateUser(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }
    @Override
    public void deactivateUser(Long id, User user) {
        user.setId(id);
        user.setActive(false);
        userRepository.save(user);
    }
}
