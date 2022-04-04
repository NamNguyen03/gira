package com.nam_nguyen_03.application.security.service;

import com.nam_nguyen_03.application.security.dto.LoginDTO;

public interface AuthService {

    String login(LoginDTO loginDTO);
    
}
