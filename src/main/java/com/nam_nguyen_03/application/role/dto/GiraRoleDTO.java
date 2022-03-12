/**
 * 
 */
package com.nam_nguyen_03.application.role.dto;

import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;

/**
 * @author nam
 *
 */
@Getter
@Setter
public class GiraRoleDTO {
	private UUID id;
	
	@Size(max = 30 , min =  3 , message = "length code should to 3 from 30 character")
	private String code;
	@NotBlank(message = "description should not blank")
	private String description;

	private Set<GiraGroupDTO> groups;
}
