package com.hrms.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.userservice.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
    
}
