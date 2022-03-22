/**
 * 
 */
package com.nam_nguyen_03.application.role.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.nam_nguyen_03.application.common.util.ResponseHelper;
import com.nam_nguyen_03.application.role.dto.GiraGroupDTO;
import com.nam_nguyen_03.application.role.dto.GiraGroupWithRolesDTO;
import com.nam_nguyen_03.application.role.service.GiraGroupService;

/**
 * @author nam
 *
 */
@RestController
@RequestMapping("groups")
@Slf4j
public class GiraGroupController {
	@Autowired
	private GiraGroupService service;
	
	@GetMapping
	public Object findAllGroups() {
		log.info("Find all gira groups STARTED");
		return ResponseHelper.getResponse( service.findAllDto(), HttpStatus.OK, false);
	}
	
	@PostMapping
	public Object createNewGroup(@Valid @RequestBody GiraGroupDTO dto,
			BindingResult result) {
		if(result.hasErrors()) {
			return ResponseHelper.getResponse(result, HttpStatus.BAD_REQUEST, true);
		}
		
		return ResponseHelper.getResponse(service.createNewGroup(dto), HttpStatus.CREATED, false);
	}
	
	@PostMapping("add-role/{group-id}/{role-id}")
	public Object addRole(@PathVariable(name = "group-id") String groupId,
			@PathVariable(name = "role-id") String roleId) {
		GiraGroupWithRolesDTO modifiedGroup = service.addRole(groupId, roleId);
		
		if (modifiedGroup == null) {
			return ResponseHelper.getResponse("Group or Role is not existing"
							, HttpStatus.BAD_REQUEST, true);
		}
		
		return ResponseHelper.getResponse(modifiedGroup, HttpStatus.OK, false);
	}
	
	@DeleteMapping("remove-role/{group-id}/{role-id}")
	public Object removeRole(@PathVariable(name = "group-id") String groupId,
			@PathVariable(name = "role-id") String roleId) {
		GiraGroupWithRolesDTO modifiedGroup = service.removeRole(groupId, roleId);
		
		if (modifiedGroup == null) {
			return ResponseHelper.getResponse("Group or Role is not existing"
							, HttpStatus.BAD_REQUEST, true);
		}
		
		return ResponseHelper.getResponse(modifiedGroup, HttpStatus.OK, false);
	}
}
