package com.nam_nguyen_03.application.user.service;

import java.util.List;

import com.nam_nguyen_03.application.user.dto.GiraUserDTO;

/**
 * @author nam
 *
 */
public interface GiraUserService {

    GiraUserDTO createUser( GiraUserDTO user);

    List<GiraUserDTO> findAll();
    
}
