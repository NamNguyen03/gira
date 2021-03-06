package com.nam_nguyen_03.application.security.validation.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.nam_nguyen_03.application.security.validation.validator.UsernameNotExistsValidator;

/**
 * @author nam
 *
 */
@Constraint(validatedBy = UsernameNotExistsValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface UsernameNotExists {
    String message() default "Username not exists.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
