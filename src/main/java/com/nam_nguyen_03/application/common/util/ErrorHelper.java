package com.nam_nguyen_03.application.common.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
/**
 * @author nam
 *
 */
public class ErrorHelper {

    private ErrorHelper(){ }

    public static List<String> getAllError(BindingResult result){
		return result.getAllErrors()
					.stream()
					.map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.toList());
	}
}
