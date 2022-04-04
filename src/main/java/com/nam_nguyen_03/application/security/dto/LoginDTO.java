package com.nam_nguyen_03.application.security.dto;

import javax.validation.constraints.Size;

import com.nam_nguyen_03.application.security.validation.anotation.UsernameNotExists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDTO {
    @Size(min = 3, max = 100, message = "{user.username.size}")
    @UsernameNotExists(message = "{security.user.username.notExists}")
    private String username;
    private String password;
}
