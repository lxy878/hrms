package com.hrms.adminservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.Address;
import com.hrms.adminservice.repository.AddressRepository;

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
    
}
