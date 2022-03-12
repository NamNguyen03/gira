/**
 * 
 */
package com.nam_nguyen_03.application.role.service;

import java.util.List;

import com.nam_nguyen_03.application.role.dto.GiraRoleDTO;
import com.nam_nguyen_03.application.role.model.GiraRole;

/**
 * @author nam
 *
 */
public interface GiraRoleService {
	List<GiraRoleDTO> findAllEntity();
	GiraRole save(GiraRoleDTO dto);
}