package com.hrms.adminservice.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.adminservice.domain.Role;
import com.hrms.adminservice.domain.User;
import com.hrms.adminservice.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleServiceImp roleServiceImp;

    @Override
    public List<User> findAll() {
        
        return userRepository.findAll();
    }

    @Override
    public User save(String name, String email, String pwd) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(pwd);

        Role newRole = roleServiceImp.findByName("ROLE_USER");
        if(newRole == null){
            newRole = new Role();
            newRole.setName("ROLE_USER");
        }
        newUser.getRoles().add(newRole);
        return userRepository.save(newUser);
    }

    @Override
    public void deleteUserById(long uId) { 
        userRepository.deleteById(uId);
    }

    @Override
    public User findById(long uId) {
        Optional<User> user = userRepository.findById(uId);
        if(!user.isPresent()) return null;
        return user.get();
    }

    @Override
    public User findByName(String userName) {
        
        return userRepository.findByName(userName);
    }
    
}
