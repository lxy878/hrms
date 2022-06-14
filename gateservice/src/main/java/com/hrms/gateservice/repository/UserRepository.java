package com.hrms.gateservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.gateservice.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{
    public User findByName(String name);
}
