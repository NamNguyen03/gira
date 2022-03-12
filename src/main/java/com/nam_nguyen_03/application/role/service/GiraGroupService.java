/**
 * 
 */
package com.nam_nguyen_03.application.role.service;

import java.util.List;

import com.nam_nguyen_03.application.role.dto.GiraGroupDTO;
import com.nam_nguyen_03.application.role.dto.GiraGroupWithRolesDTO;

/**
 * @author nam
 *
 */
public interface GiraGroupService {
	List<GiraGroupDTO> findAllDto();
	GiraGroupDTO createNewGroup(GiraGroupDTO dto);
	GiraGroupWithRolesDTO addRole(String groupId, String roleId);
	GiraGroupWithRolesDTO removeRole(String groupId, String roleId);
}
