package com.hrms.adminservice.services;

import com.hrms.adminservice.domain.Role;

public interface RoleService {
    public Role findByName(String name);
    
}
