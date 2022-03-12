/**
 * 
 */
package com.nam_nguyen_03.application.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nam_nguyen_03.application.role.dto.GiraGroupDTO;
import com.nam_nguyen_03.application.role.dto.GiraGroupWithRolesDTO;
import com.nam_nguyen_03.application.role.model.GiraGroup;

/**
 * @author nam
 *
 */
@Mapper
public interface GiraGroupMapper {
	GiraGroupMapper INSTANCE = Mappers.getMapper(GiraGroupMapper.class);
	
	GiraGroupDTO toDTO(GiraGroup model);
	GiraGroup toModel(GiraGroupDTO dto);
	GiraGroupWithRolesDTO toDtoWithRoles(GiraGroup modifiedGroup);
}
