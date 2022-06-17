package com.hrms.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.adminservice.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
    
}
