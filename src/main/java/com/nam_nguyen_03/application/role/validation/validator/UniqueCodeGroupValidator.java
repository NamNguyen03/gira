package com.nam_nguyen_03.application.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nam_nguyen_03.application.role.repository.GiraGroupRepo;
import com.nam_nguyen_03.application.role.validation.anotation.UniqueCodeGroup;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueCodeGroupValidator implements ConstraintValidator<UniqueCodeGroup, String>  {

 
    private String message;
    
    @Autowired
    private GiraGroupRepo repo;

	@Override
	public void initialize(UniqueCodeGroup uniqueCodeGroup) {
		message = uniqueCodeGroup.message();
	}

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        
        if(code == null || code.length()< 3){
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
