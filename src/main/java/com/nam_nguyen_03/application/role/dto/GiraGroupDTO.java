/**
 * 
 */
package com.nam_nguyen_03.application.role.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.nam_nguyen_03.application.role.validation.anotation.UniqueCodeGroup;

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
	
	@Size(min = 3, max = 36, message = "{group.code.size}")
	@UniqueCodeGroup(message = "{group.code.unique}" )
	private String code;
	
	@NotBlank(message = "{group.description.notblank}")
	private String description;
}
