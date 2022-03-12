/**
 * 
 */
package com.nam_nguyen_03.application.role.dto;

import java.util.Set;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/**
 * @author nam
 *
 */
@Getter
@Setter
public class GiraGroupWithRolesDTO {
	private UUID id;
	
	private String code;
	
	private String description;
	
	private Set<GiraRoleDTO> roles;
}
