package com.hrms.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.userservice.domain.Address;
import com.hrms.userservice.repository.AddressRepository;

@Service
public class AddressServiceImp implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address save(JsonNode address) {
        Address newAddress = new Address();
        newAddress.setState(address.get("state").asText());
        newAddress.setCity(address.get("city").asText());
        newAddress.setStreet(address.get("street").asText());
        newAddress.setZipCode(address.get("zipCode").asInt());
        newAddress.setResidenceNumber(address.get("residenceNumber").asText());
        newAddress.setLocality(address.get("locality").asText());
        return addressRepository.save(newAddress);
    }

    @Override
    public Address update(JsonNode address) {
        
        Optional<Address> a = addressRepository.findById(address.get("id").asLong());
        if(!a.isPresent()) return null;
        
        Address addr = a.get();
        addr.setState(address.get("state").asText());
        addr.setCity(address.get("city").asText());
        addr.setStreet(address.get("street").asText());
        addr.setZipCode(address.get("zipCode").asInt());
        addr.setResidenceNumber(address.get("residenceNumber").asText());
        addr.setLocality(address.get("locality").asText());
        return addressRepository.save(addr);
    }
    
}
