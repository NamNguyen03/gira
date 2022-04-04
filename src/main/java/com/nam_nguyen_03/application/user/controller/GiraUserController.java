package com.nam_nguyen_03.application.user.controller;

import javax.validation.Valid;

import com.nam_nguyen_03.application.common.util.ResponseHelper;
import com.nam_nguyen_03.application.user.dto.GiraUserDTO;
import com.nam_nguyen_03.application.user.service.GiraUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author nam
 *
 */
@RestController
@RequestMapping("api/v1/users")
public class GiraUserController {
    
    @Autowired
    private GiraUserService service;

    @PostMapping
    public Object createUser(@Valid @RequestBody GiraUserDTO user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResponseHelper.getResponse(bindingResult, HttpStatus.BAD_REQUEST, true);
        }
        return ResponseHelper.getResponse(service.createUser(user), HttpStatus.OK, false);
    }

    @GetMapping
    public Object findAll() {
        return ResponseHelper.getResponse(service.findAll(), HttpStatus.OK, false);
    }
    
}
