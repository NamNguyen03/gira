package com.nam_nguyen_03.application.user.service;

import java.util.List;
import java.util.stream.Collectors;

import com.nam_nguyen_03.application.user.dto.GiraUserDTO;
import com.nam_nguyen_03.application.user.mapper.GiraUserMapper;
import com.nam_nguyen_03.application.user.model.GiraUser;
import com.nam_nguyen_03.application.user.repository.GiraUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author nam
 *
 */
@Service
public class GiraUserServiceImpl implements GiraUserService {

    @Autowired
    private GiraUserRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public GiraUserDTO createUser(GiraUserDTO user) {
        GiraUser rq = GiraUserMapper.INSTANCE.toModel(user);
        rq.setPassword(encoder.encode(user.getPassword()));
       
        GiraUserDTO rp = GiraUserMapper.INSTANCE.toDTO(repo.save(rq));
        rp.setPassword("");
        return rp;
    }

    @Override
    public List<GiraUserDTO> findAll() {
        return repo.findAll()
                    .stream()
                    .map(GiraUserMapper.INSTANCE::toDTO)
                    .collect(Collectors.toList());
    }
    
}
