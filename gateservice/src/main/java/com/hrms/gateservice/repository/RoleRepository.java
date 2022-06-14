package com.hrms.gateservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.gateservice.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    public Role findByName(String name);
}
