/**
 * 
 */
package com.nam_nguyen_03.application.role.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nam_nguyen_03.application.role.dto.GiraRoleDTO;
import com.nam_nguyen_03.application.role.model.GiraRole;
import com.nam_nguyen_03.application.role.service.GiraRoleService;

/**
 * @author nam
 *
 */
@RestController
@RequestMapping("roles")
public class GiraRoleController {
	@Autowired
	private GiraRoleService service;
	
	@GetMapping
	public Object findAllRoles() {
		return new ResponseEntity<>(service.findAllEntity(), HttpStatus.OK);
	}
	
	@PostMapping
	public Object createNewRole(@Valid @RequestBody GiraRoleDTO dto, 
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors()
					.stream().map(t -> t.getDefaultMessage()).collect(Collectors.toList())
					, HttpStatus.BAD_REQUEST);
		}
		
		GiraRole role = service.save(dto);
		return new ResponseEntity<>(role, HttpStatus.CREATED);
	}
}
