package com.nam_nguyen_03.application.security.controller;

import javax.validation.Valid;

import com.nam_nguyen_03.application.common.util.ResponseHelper;
import com.nam_nguyen_03.application.security.dto.LoginDTO;
import com.nam_nguyen_03.application.security.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nam
 *
 */
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
   
    @PostMapping("login")
    public Object login(@Valid @RequestBody LoginDTO loginDTO, BindingResult result) {
        if(result.hasErrors()) {
			return ResponseHelper.getResponse(result, HttpStatus.BAD_REQUEST, true);
		}
		
        return ResponseHelper.getResponse(authService.login(loginDTO), HttpStatus.OK, false);
    }
}
