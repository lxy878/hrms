package com.hrms.adminservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.adminservice.domain.Role;
import com.hrms.adminservice.repository.RoleRepository;

@Service
public class RoleServiceImp implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
    
}
