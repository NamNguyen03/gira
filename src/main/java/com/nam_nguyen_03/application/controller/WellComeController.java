/**
 * 
 */
package com.nam_nguyen_03.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nam
 *
 */
@RestController
public class WellComeController {
	
	@GetMapping("/hello")
	public String wellcome() {
		return "Hello";
	}
}
