package com.hsf.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.hsf.service.UserService;
import com.hsf.dto.UserResponseDTO;
import com.hsf.entity.User;
import com.hsf.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;
    // Define REST endpoints here (e.g., GET, POST, PUT, DELETE)


    @GetMapping
    public List<UserResponseDTO> getAll() {
        
        List<User> users = userService.getAllUsers(); //List of users from database
        List<UserResponseDTO> userResponseDTOs = new ArrayList<>(); //New lists of DTOs entities

        for(User u : users){ //go via user list from database
            UserResponseDTO userResponseDTO = userMapper.toUserResponseDTO(u); //mapping from User to dto
            userResponseDTOs.add(userResponseDTO); //save in list DTOs
        }

        return userResponseDTOs;
    }
    
}
