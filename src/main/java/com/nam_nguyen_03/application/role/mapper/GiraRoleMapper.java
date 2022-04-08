/**
 * 
 */
package com.nam_nguyen_03.application.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nam_nguyen_03.application.role.dto.GiraRoleCreateDTO;
import com.nam_nguyen_03.application.role.dto.GiraRoleDTO;
import com.nam_nguyen_03.application.role.model.GiraRole;

/**
 * @author nam
 *
 */
@Mapper
public interface GiraRoleMapper {
	GiraRoleMapper INSTANCE = Mappers.getMapper(GiraRoleMapper.class);
	
	GiraRole mapToEntity(GiraRoleDTO dto);
	GiraRoleDTO toDto(GiraRole dto);
    GiraRole mapFromCreateDtoToEntity(GiraRoleCreateDTO dto);
}
