/**
 * 
 */
package com.nam_nguyen_03.application.role.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.nam_nguyen_03.application.role.validation.anotation.UniqueCodeRole;

import lombok.Getter;
import lombok.Setter;

/**
 * @author nam
 *
 */
@Getter
@Setter
public class GiraGroupDTO {
	private UUID id;
	
	@Size(min = 5, max = 36, message = "{group.code.size}")
	@UniqueCodeRole(message = "{group.code.unique-code}" )
	private String code;
	
	@NotBlank(message = "{group.description.notblank}")
	private String description;
}
