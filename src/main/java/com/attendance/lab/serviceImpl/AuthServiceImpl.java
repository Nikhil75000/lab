package com.attendance.lab.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.attendance.lab.Repository.UserRepository;
import com.attendance.lab.Services.AuthService;
import com.attendance.lab.customUserDetails.CustomUserDetails;
import com.attendance.lab.entity.User;
import com.attendance.lab.io.LoginDTO;
import com.attendance.lab.io.RegisterDTO;
import com.attendance.lab.io.UserDTO;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authManager;

    @Override
    public UserDTO register(RegisterDTO dto) {

        if (repo.findByUsername(dto.getUsername()).isPresent()) {
            throw new IllegalStateException("Username already exists");
        }

        if (!dto.getRole().equals("TEACHER") && !dto.getRole().equals("STUDENT")) {
            throw new IllegalArgumentException("Role must be TEACHER or STUDENT");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());

        repo.save(user);
        return toDTO(user);
    }

    @Override
    public UserDTO login(LoginDTO dto) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(), dto.getPassword()));

        CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
        return toDTO(details.getUser());
    }

    private UserDTO toDTO(User u) {
        UserDTO dto = new UserDTO();
        dto.setId(u.getId());
        dto.setUsername(u.getUsername());
        dto.setRole(u.getRole());
        return dto;
    }
}
