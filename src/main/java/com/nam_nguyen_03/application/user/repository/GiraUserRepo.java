package com.nam_nguyen_03.application.user.repository;

import java.util.Optional;
import java.util.UUID;


import com.nam_nguyen_03.application.user.model.GiraUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author nam
 *
 */
@Repository
public interface GiraUserRepo extends JpaRepository<GiraUser, UUID>{
    
    @Query("SELECT u FROM GiraUser u LEFT JOIN FETCH u.groups WHERE u.username = ?1")
    Optional<GiraUser> findByUsername(String username);

    Optional<GiraUser> findByEmail(String email);
    
}
