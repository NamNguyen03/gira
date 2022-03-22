package com.nam_nguyen_03.application.user.valication.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nam_nguyen_03.application.user.model.GiraUser;
import com.nam_nguyen_03.application.user.repository.GiraUserRepo;
import com.nam_nguyen_03.application.user.valication.anotation.UniqueUsername;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author nam
 *
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private String message;
	
	@Autowired
	private GiraUserRepo repository;
	
	@Override
	public void initialize(UniqueUsername uniqueUsername) {
		message = uniqueUsername.message();
	}
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if(username == null){
            context.buildConstraintViolationWithTemplate("username not null")
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
            return false;
        }
			
		
		Optional<GiraUser> userOpt = repository.findByUsername(username);
		if(userOpt.isEmpty()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		return false;
	}
}
