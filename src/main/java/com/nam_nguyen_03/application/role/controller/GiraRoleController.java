/**
 * 
 */
package com.nam_nguyen_03.application.role.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.nam_nguyen_03.application.common.util.ResponseHelper;
import com.nam_nguyen_03.application.role.dto.GiraRoleCreateDTO;
import com.nam_nguyen_03.application.role.dto.GiraRoleDTO;
import com.nam_nguyen_03.application.role.service.GiraRoleService;

/**
 * @author nam
 *
 */
@Slf4j
@RestController
@RequestMapping("api/v1/roles")
public class GiraRoleController {
	@Autowired
	private GiraRoleService service;
	
	@GetMapping
	public Object findAllRoles() {
		log.info("Find all roles");

		return ResponseHelper.getResponse(service.findAllEntity(), HttpStatus.OK, false);
	}
	
	@PostMapping
	public Object createNewRole(@Valid @RequestBody GiraRoleCreateDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHelper.getResponse(bindingResult, HttpStatus.BAD_REQUEST, true);
		}
		
		return ResponseHelper.getResponse(service.save(dto), HttpStatus.CREATED, false);
	}

	@PutMapping("/{id}")
	public Object updateRole(@Valid @RequestBody GiraRoleDTO dto, BindingResult bindingResult, @PathVariable("id") UUID id) {
		if(bindingResult.hasErrors()) {
			return ResponseHelper.getResponse(bindingResult, HttpStatus.BAD_REQUEST, true);
		}
		return ResponseHelper.getResponse(service.update(id,dto), HttpStatus.OK, false);
	}
}
