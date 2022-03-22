package com.nam_nguyen_03.application.user.service;

import java.util.List;
import java.util.stream.Collectors;

import com.nam_nguyen_03.application.user.dto.GiraUserDTO;
import com.nam_nguyen_03.application.user.mapper.GiraUserMapper;
import com.nam_nguyen_03.application.user.repository.GiraUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nam
 *
 */
@Service
public class GiraUserServiceImpl implements GiraUserService {

    @Autowired
    private GiraUserRepo repo;

    @Override
    public GiraUserDTO createUser(GiraUserDTO user) {
     
        return GiraUserMapper.INSTANCE.toDTO(repo.save(GiraUserMapper.INSTANCE.toModel(user)));
    }

    @Override
    public List<GiraUserDTO> findAll() {
        return repo.findAll()
                    .stream()
                    .map(GiraUserMapper.INSTANCE::toDTO)
                    .collect(Collectors.toList());
    }
    
}
