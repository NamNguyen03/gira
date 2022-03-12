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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nam_nguyen_03.application.role.dto.GiraGroupDTO;
import com.nam_nguyen_03.application.role.dto.GiraGroupWithRolesDTO;
import com.nam_nguyen_03.application.role.service.GiraGroupService;

/**
 * @author nam
 *
 */
@RestController
@RequestMapping("groups")
public class GiraGroupController {
	@Autowired
	private GiraGroupService service;
	
	@GetMapping
	public Object findAllGroups() {
		List<GiraGroupDTO> groups = service.findAllDto();
		
		return new ResponseEntity<>(groups, HttpStatus.OK);
	}
	
	@PostMapping
	public Object createNewGroup(@Valid @RequestBody GiraGroupDTO dto,
			BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<>(result.getAllErrors()
					.stream().map(t -> t.getDefaultMessage()).collect(Collectors.toList()), HttpStatus.BAD_REQUEST);
		}
		
		GiraGroupDTO newGroup = service.createNewGroup(dto);
		
		return new ResponseEntity<>(newGroup, HttpStatus.CREATED);
	}
	
	@PostMapping("add-role/{group-id}/{role-id}")
	public Object addRole(@PathVariable(name = "group-id") String groupId,
			@PathVariable(name = "role-id") String roleId) {
		GiraGroupWithRolesDTO modifiedGroup = service.addRole(groupId, roleId);
		
		if (modifiedGroup == null) {
			return new ResponseEntity<>("Group or Role is not existing"
							, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(modifiedGroup, HttpStatus.OK);
	}
	
	@DeleteMapping("remove-role/{group-id}/{role-id}")
	public Object removeRole(@PathVariable(name = "group-id") String groupId,
			@PathVariable(name = "role-id") String roleId) {
		GiraGroupWithRolesDTO modifiedGroup = service.removeRole(groupId, roleId);
		
		if (modifiedGroup == null) {
			return new ResponseEntity<>("Group or Role is not existing"
							, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(modifiedGroup, HttpStatus.OK);
	}
}
