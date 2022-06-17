package com.hrms.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.adminservice.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    public Role findByName(String name);
}
