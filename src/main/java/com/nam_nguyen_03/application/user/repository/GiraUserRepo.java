package com.nam_nguyen_03.application.user.repository;

import java.util.Optional;
import java.util.UUID;


import com.nam_nguyen_03.application.user.model.GiraUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nam
 *
 */
@Repository
public interface GiraUserRepo extends JpaRepository<GiraUser, UUID>{

    Optional<GiraUser> findByUsername(String username);

    Optional<GiraUser> findByEmail(String email);
    
}
