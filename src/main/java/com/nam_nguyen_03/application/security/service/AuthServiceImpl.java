package com.nam_nguyen_03.application.security.service;

import java.util.Optional;

import com.nam_nguyen_03.application.security.dto.LoginDTO;
import com.nam_nguyen_03.application.security.jwt.JwtHelper;
import com.nam_nguyen_03.application.user.model.GiraUser;
import com.nam_nguyen_03.application.user.repository.GiraUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author nam
 *
 */
@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
	private GiraUserRepo repository;

    @Autowired
	private PasswordEncoder passwordEncoder;

    @Autowired
	private JwtHelper jwts;
	

    @Override
    public String login(LoginDTO loginDTO) {
        Optional<GiraUser> userOpt = repository.findByUsername(loginDTO.getUsername());
		
		String encodedPassword = userOpt.get().getPassword();
		
		if(passwordEncoder.matches(loginDTO.getPassword(), encodedPassword)) {
			return jwts.generateJwtToken(loginDTO.getUsername());
		}
		
		return null;
    }
    
}
