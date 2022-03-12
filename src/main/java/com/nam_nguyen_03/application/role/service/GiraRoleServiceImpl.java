/**
 * 
 */
package com.nam_nguyen_03.application.role.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nam_nguyen_03.application.role.dto.GiraRoleDTO;
import com.nam_nguyen_03.application.role.mapper.GiraRoleMapper;
import com.nam_nguyen_03.application.role.model.GiraRole;
import com.nam_nguyen_03.application.role.repository.GiraRoleRepo;

/**
 * @author nam
 *
 */
@Service
public class GiraRoleServiceImpl implements GiraRoleService {

	@Autowired
	private GiraRoleRepo repository;

	@Override
	public List<GiraRoleDTO> findAllEntity() {
		return repository.findAll()
						.stream()
						.map(GiraRoleMapper.INSTANCE::toDto)
						.collect(Collectors.toList());
	}

	@Override
	public GiraRoleDTO save(GiraRoleDTO dto) {
		// map dto to entity
		GiraRole role = GiraRoleMapper.INSTANCE.mapToEntity(dto);
		return GiraRoleMapper.INSTANCE.toDto(repository.save(role));
	}

}
