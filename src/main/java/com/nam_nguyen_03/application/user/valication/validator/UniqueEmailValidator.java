package com.nam_nguyen_03.application.user.valication.validator;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nam_nguyen_03.application.user.model.GiraUser;
import com.nam_nguyen_03.application.user.repository.GiraUserRepo;
import com.nam_nguyen_03.application.user.valication.anotation.UniqueEmail;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailValidator  implements ConstraintValidator<UniqueEmail, String> {
	private String message;
	
	@Autowired
	private GiraUserRepo repository;
	
	@Override
	public void initialize(UniqueEmail uniqueEmail) {
		message = uniqueEmail.message();
	}
	
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
        if(email == null){
            context.buildConstraintViolationWithTemplate("email not null")
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
            return false;
        }
			

		Optional<GiraUser> userOpt = repository.findByEmail(email);
		
		if(userOpt.isEmpty()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
		return false;
	}

}
