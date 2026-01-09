package com.hsf.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.hsf.service.UserService;
import com.hsf.entity.User;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Define REST endpoints here (e.g., GET, POST, PUT, DELETE)
    
}
