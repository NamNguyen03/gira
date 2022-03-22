package com.nam_nguyen_03.application.user.mapper;

import com.nam_nguyen_03.application.user.dto.GiraUserDTO;
import com.nam_nguyen_03.application.user.model.GiraUser;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
/**
 * @author nam
 *
 */
@Mapper
public interface GiraUserMapper {
    GiraUserMapper INSTANCE = Mappers.getMapper(GiraUserMapper.class);
	
	GiraUser toModel(GiraUserDTO dto);
	
	GiraUserDTO toDTO(GiraUser model);
}
