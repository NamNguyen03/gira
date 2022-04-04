/**
 * 
 */
package com.nam_nguyen_03.application.role.service;

import java.util.List;
import java.util.UUID;

import com.nam_nguyen_03.application.role.dto.GiraRoleDTO;

/**
 * @author nam
 *
 */
public interface GiraRoleService {
	List<GiraRoleDTO> findAllEntity();
	GiraRoleDTO save(GiraRoleDTO dto);
    GiraRoleDTO update(UUID id, GiraRoleDTO dto);
}
