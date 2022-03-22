package com.nam_nguyen_03.application.user.valication.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.nam_nguyen_03.application.user.valication.validator.UniqueUsernameValidator;

/**
 * @author nam
 *
 */
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface UniqueUsername {
    String message() default "Username already used.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}