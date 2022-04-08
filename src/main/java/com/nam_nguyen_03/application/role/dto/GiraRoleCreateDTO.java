package com.nam_nguyen_03.application.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.nam_nguyen_03.application.role.validation.anotation.UniqueCodeRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiraRoleCreateDTO {
    @Size(max = 30 , min =  3 , message = "{role.code.size}")
	@UniqueCodeRole(message ="{role.code.unique}")
	private String code;
	@NotBlank(message = "{role.description.notblank}")
	private String description;
}
