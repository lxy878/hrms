package com.hrms.gateservice.restclients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.gateservice.domain.User;
import com.hrms.gateservice.services.UserServiceImp;

@Component
public class AdminClient {
    private String baseUrl = "http://localhost:8282";
    
    @Autowired
    UserServiceImp userServiceImp;

    public JsonNode addUser(JsonNode json){
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(json.toString(), headers);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(baseUrl+"/saveEmp", entity, Object.class);
    
        Object body = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode respond = mapper.convertValue(body, JsonNode.class);
        
        encodePassword(respond.get("emailId").asLong());
        return respond;
    }

    private void encodePassword(Long uId){
        User u = userServiceImp.findById(uId);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        u.setPassword(encoder.encode(u.getPassword()));
        userServiceImp.save(u);
    }

    public JsonNode postRequest(JsonNode json, String path){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(json.toString(), headers);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(baseUrl+path, entity, Object.class);
    
        Object body = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode respond = mapper.convertValue(body, JsonNode.class);
    
        return respond;
    }

    public JsonNode getRequest(String path){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(baseUrl+path, Object.class);

        Object body = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.convertValue(body, JsonNode.class);
        return json;
    }

}
