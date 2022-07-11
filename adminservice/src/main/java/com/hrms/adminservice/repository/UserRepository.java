package com.hrms.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.adminservice.domain.User;

public interface UserRepository extends JpaRepository<User,Long>{
    public User findByName(String name);
    public void deleteById(Long id);
}
