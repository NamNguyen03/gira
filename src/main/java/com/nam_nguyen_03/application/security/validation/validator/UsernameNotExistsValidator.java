package com.nam_nguyen_03.application.security.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nam_nguyen_03.application.security.validation.anotation.UsernameNotExists;
import com.nam_nguyen_03.application.user.model.GiraUser;
import com.nam_nguyen_03.application.user.repository.GiraUserRepo;

import org.springframework.beans.factory.annotation.Autowired;

public class UsernameNotExistsValidator implements ConstraintValidator<UsernameNotExists, String>  {
    private String message;
	
	@Autowired
	private GiraUserRepo repository;
	
	@Override
	public void initialize(UsernameNotExists usernameNotExists ) {
		message = usernameNotExists.message();
	}
	
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
        if(username == null){
            context.buildConstraintViolationWithTemplate("email not null")
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
            return false;
        }
			

		Optional<GiraUser> userOpt = repository.findByUsername(username);
		
		if(userOpt.isPresent()) {
			return true;
		}
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
		return false;
	}

}
