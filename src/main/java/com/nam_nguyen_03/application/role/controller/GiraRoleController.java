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

import com.nam_nguyen_03.application.common.util.ResponseHelper;
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
		return ResponseHelper.getResponse(service.findAllEntity(), HttpStatus.OK, false);
	}
	
	@PostMapping
	public Object createNewRole(@Valid @RequestBody GiraRoleDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHelper.getResponse(bindingResult, HttpStatus.BAD_REQUEST, true);
		}
		
		return ResponseHelper.getResponse(service.save(dto), HttpStatus.CREATED, false);
	}
}
