package com.hrms.userservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.userservice.domain.Address;

public interface AddressService {
    public Address save(JsonNode address);   
    public Address update(JsonNode address); 
}
