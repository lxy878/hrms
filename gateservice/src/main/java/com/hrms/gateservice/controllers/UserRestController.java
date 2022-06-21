package com.hrms.gateservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.gateservice.restclients.UserClient;

@RestController
public class UserRestController {
    
    @Autowired
    UserClient userClient;

    @GetMapping("/getAttendance/{uId}")
    private ResponseEntity<JsonNode> getAttendance(@PathVariable Long uId){
        JsonNode json = userClient.getAttendance("/getAttendance/"+uId);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
