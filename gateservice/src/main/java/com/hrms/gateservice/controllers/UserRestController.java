package com.hrms.gateservice.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hrms.gateservice.domain.User;
import com.hrms.gateservice.restclients.UserClient;
import com.hrms.gateservice.services.UserService;

@RestController
public class UserRestController {
    
    @Autowired
    UserClient userClient;

    @Autowired
    UserService userService;

    @GetMapping("/getAttendance/{uId}")
    private ResponseEntity<JsonNode> getAttendance(@PathVariable Long uId){
        JsonNode json = userClient.getAttendance("/getAttendance/"+uId);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @PostMapping("/submitLeave")
    private ResponseEntity<JsonNode> submitLeave(@RequestBody JsonNode json){
        JsonNode respond = userClient.postRequest(json, "/submitLeave");
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }

    @GetMapping("/getLeaves/{uId}")
    private ResponseEntity<JsonNode> getLeaves(@PathVariable Long uId){
        JsonNode json = userClient.getRequest("/getLeaves/"+uId);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/getApprover/{uId}")
    private ResponseEntity<JsonNode> getApprover(@PathVariable Long uId){
        JsonNode json = userClient.getRequest("/getApprover/"+uId);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @PostMapping("/submitResignation")
    private ResponseEntity<JsonNode> submitResignation(@RequestBody JsonNode json){
        JsonNode respond = userClient.postRequest(json, "/submitResignation");
        return new ResponseEntity<>(respond, HttpStatus.OK);
    }

    @GetMapping("/getEmployee/{uId}")
    private ResponseEntity<JsonNode> getEmp(@PathVariable Long uId){
        JsonNode json = userClient.getRequest("/getEmployee/"+uId);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    // @PostMapping("/updateEmployee")
    // private ResponseEntity<JsonNode> updateEmp(@RequestBody JsonNode json){
    //     // testing
    //     JsonNode respond = userClient.postRequest(json, "/updateEmployee");
    //     return new ResponseEntity<>(respond, HttpStatus.OK);
    // }

    @PostMapping("/changePassword")
    private Map<String,String> changePassword(@RequestBody JsonNode json){

        User user = userService.findById(json.get("uId").asLong());
        String oldPassword = json.get("oldPassword").asText();
        String newPassword = json.get("newPassword").asText();
        String message = userService.updatePassword(user, oldPassword, newPassword);
        Map<String, String> map = new HashMap<>();
        map.put("message", message);
        return map;
    }
}
