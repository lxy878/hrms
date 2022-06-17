package com.hrms.adminservice.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.adminservice.domain.Address;

public interface AddressService {
    public Address save(JsonNode address);    
}
