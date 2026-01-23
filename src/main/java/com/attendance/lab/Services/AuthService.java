package com.attendance.lab.Services;

import com.attendance.lab.io.LoginDTO;
import com.attendance.lab.io.RegisterDTO;
import com.attendance.lab.io.UserDTO;

public interface AuthService {
    UserDTO register(RegisterDTO dto);

    UserDTO login(LoginDTO dto);
}
