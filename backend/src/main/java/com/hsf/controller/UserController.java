package com.hsf.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hsf.service.UserService;
import com.hsf.dto.UserRequestDTO;
import com.hsf.dto.UserResponseDTO;
import com.hsf.entity.User;
import com.hsf.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
    public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
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
    
    @GetMapping("/{id}")
        public UserResponseDTO getById(@PathVariable Long id){

         User user = userService.getUserById(id);
         return userMapper.toUserResponseDTO(user);
    }

    @PostMapping("/add")
        public UserResponseDTO addUser(@RequestBody UserRequestDTO userRequestDTO){  //frontend layer

        User user = userService.createUser(userMapper.toUserEntity(userRequestDTO)); //service layer
        return userMapper.toUserResponseDTO(user); //return to frontend
    }

    @PutMapping("/{id}")
        public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){ //front
            User user = userService.updateUser(id, userMapper.toUserEntity(userRequestDTO)); //user service made update func. in params id and mapping to entity
            return userMapper.toUserResponseDTO(user); // return value in json style
    }

    @PutMapping("/{id}/deactivate")
        public ResponseEntity<Void> deactivateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){
            userService.deactivateUser(id, userMapper.toUserEntity(userRequestDTO));
            return ResponseEntity.ok().build();
        }
    

}