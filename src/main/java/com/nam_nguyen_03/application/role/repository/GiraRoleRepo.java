/**
 * 
 */
package com.nam_nguyen_03.application.role.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nam_nguyen_03.application.role.model.GiraRole;

/**
 * @author nam
 *
 */
@Repository
public interface GiraRoleRepo extends JpaRepository<GiraRole, UUID> {

}
