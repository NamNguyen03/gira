package com.nam_nguyen_03.application.role.validation.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.nam_nguyen_03.application.role.validation.validator.UniqueCodeGroupValidator;

/**
 * @author nam
 *
 */
@Constraint(validatedBy = UniqueCodeGroupValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface UniqueCodeGroup {
    String message() default "Code is existed.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
