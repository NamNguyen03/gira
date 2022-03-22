/**
 * 
 */
package com.nam_nguyen_03.application.role.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nam_nguyen_03.application.role.dto.GiraGroupDTO;
import com.nam_nguyen_03.application.role.dto.GiraGroupWithRolesDTO;
import com.nam_nguyen_03.application.role.mapper.GiraGroupMapper;
import com.nam_nguyen_03.application.role.model.GiraGroup;
import com.nam_nguyen_03.application.role.model.GiraRole;
import com.nam_nguyen_03.application.role.repository.GiraGroupRepo;
import com.nam_nguyen_03.application.role.repository.GiraRoleRepo;

/**
 * @author nam
 *
 */
@Service
public class GiraGroupServiceImpl implements GiraGroupService {
	
	@Autowired
	private GiraGroupRepo repository;
	
	@Autowired
	private GiraRoleRepo roleRepository;

	@Override
	public List<GiraGroupDTO> findAllDto() {
		List<GiraGroup> groups = repository.findAll();
		return groups.stream()
				.map(GiraGroupMapper.INSTANCE::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	public GiraGroupDTO createNewGroup(GiraGroupDTO dto) {
		return GiraGroupMapper.INSTANCE.toDTO(repository.save(GiraGroupMapper.INSTANCE.toModel(dto)));
	}

	@Override
	public GiraGroupWithRolesDTO addRole(String groupId, String roleId) {
		GiraGroup group; 
		GiraRole  role;
		try {
			group = repository.getById(UUID.fromString(groupId));
			role = roleRepository.getById(UUID.fromString(roleId));
		} catch (EntityNotFoundException ex) {
			return null;
		}
		
		group.addRole(role);
		
		return GiraGroupMapper.INSTANCE.toDtoWithRoles(repository.save(group));
	}

	@Override
	public GiraGroupWithRolesDTO removeRole(String groupId, String roleId) {
		GiraGroup group; 
		GiraRole  role;
		try {
			group = repository.getById(UUID.fromString(groupId));
			role = roleRepository.getById(UUID.fromString(roleId));
		} catch (EntityNotFoundException ex) {
			return null;
		}
		
		group.removeRole(role);
		
		return GiraGroupMapper.INSTANCE.toDtoWithRoles(repository.save(group));
	}

}
