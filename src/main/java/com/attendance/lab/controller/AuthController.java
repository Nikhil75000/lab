package com.attendance.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.lab.Services.AuthService;
import com.attendance.lab.io.LoginDTO;
import com.attendance.lab.io.RegisterDTO;
import com.attendance.lab.io.UserDTO;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public UserDTO register(@RequestBody RegisterDTO dto) {
        return service.register(dto);
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginDTO dto) {
        return service.login(dto);
    }
}
