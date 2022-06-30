package com.hrms.gateservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.gateservice.restclients.AdminClient;

@RestController
public class AdminRestController {
    
    @Autowired
    AdminClient adminClient;

    @PostMapping("/addEmp")
    private ResponseEntity<JsonNode> addEmp(@RequestBody JsonNode json){
        return new ResponseEntity<>(adminClient.addUser(json), HttpStatus.OK);
    }

    @GetMapping("/getEmpLeaves/{uId}")
    private ResponseEntity<JsonNode> getLeaves(@PathVariable Long uId){
        JsonNode respond = adminClient.getRequest("/getEmpLeaves/"+uId);
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }
    
    @PostMapping("/updateEmpLeave")
    private ResponseEntity<JsonNode> updateEmpLeave(@RequestBody JsonNode json){
        JsonNode respond = adminClient.postRequest(json, "/updateLeave");
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }
}
