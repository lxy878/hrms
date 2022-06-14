package com.hrms.gateservice.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrms.gateservice.domain.Role;
import com.hrms.gateservice.domain.User;

@Service
public class UserDetailServiceImp implements UserDetailsService{

    @Autowired
    UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByName(username);
		Set<GrantedAuthority> ga = new HashSet<>();
		Set<Role> roles = user.getRoles();
		for(Role role:roles) {
			System.out.println("role.getRoleName(): "+role.getName());
			ga.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),ga);
    }
    
}
