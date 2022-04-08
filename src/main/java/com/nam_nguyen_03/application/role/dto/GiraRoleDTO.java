/**
 * 
 */
package com.nam_nguyen_03.application.role.dto;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author nam
 *
 */
@Getter
@Setter
@Builder
public class GiraRoleDTO {
	private UUID id;
	
	@Size(max = 30 , min =  3 , message = "{role.code.size}")
	private String code;
	@NotBlank(message = "{role.description.notblank}")
	private String description;

	private Set<GiraGroupDTO> groups =  new LinkedHashSet<>();
}
