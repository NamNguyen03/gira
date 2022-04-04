package com.nam_nguyen_03.application.role.validation.validator;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nam_nguyen_03.application.role.repository.GiraRoleRepo;
import com.nam_nguyen_03.application.role.validation.anotation.UniqueCodeRole;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author nam
 *
 */
public class UniqueCodeRoleValidator  implements ConstraintValidator<UniqueCodeRole, String> {

    private String message;
    
    @Autowired
    private GiraRoleRepo repo;

	@Override
	public void initialize(UniqueCodeRole uniqueCodeRole) {
		message = uniqueCodeRole.message();
	}

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        
        if(code == null || code.length()< 5){
            context.buildConstraintViolationWithTemplate("code must be length longer than 5")
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
            return false;
        }

        if(!repo.existsByCode(code)){
            return true;
        }

        context.buildConstraintViolationWithTemplate(message)
            .addConstraintViolation()
            .disableDefaultConstraintViolation();
		return false;
    }

}
