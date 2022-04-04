package com.nam_nguyen_03.application.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nam_nguyen_03.application.user.model.GiraUser;
import com.nam_nguyen_03.application.user.repository.GiraUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author nam
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private GiraUserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<GiraUser> userOpt = repo.findByUsername(username); 

        if(userOpt.isEmpty()) {
            throw new UsernameNotFoundException("user is empty");
        }

        GiraUser currentUser = userOpt.get();
        return new User(currentUser.getUsername(),currentUser.getPassword(), getGrantedAuthorities(currentUser));
    }
 
    private List<GrantedAuthority> getGrantedAuthorities(GiraUser user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(user.getGroups() == null || user.getGroups().isEmpty()){
            return authorities;
        }
        user.getGroups().forEach(group -> authorities.add(new SimpleGrantedAuthority(group.getCode())));
        return authorities;
    }
    
}
