/**
 * 
 */
package com.nam_nguyen_03.application.role.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nam_nguyen_03.application.role.model.GiraGroup;

/**
 * @author nam
 *
 */
@Repository
public interface GiraGroupRepo  extends JpaRepository<GiraGroup, UUID>  {

    boolean existsByCode(String code);

}
