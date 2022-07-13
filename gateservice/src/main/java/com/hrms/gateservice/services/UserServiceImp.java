package com.hrms.gateservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hrms.gateservice.domain.User;
import com.hrms.gateservice.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        
        return userRepository.findAll();
    }

    @Override
    public User save(User u) {
        return userRepository.save(u);
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
    
    @Override
    public String updatePassword(User user, String oldPassword, String newPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(oldPassword, user.getPassword())){
            return "old password is wrong";
        }
        
        user.setPassword(encoder.encode(newPassword));
        userRepository.save(user);
        return "Password is changed";
    }
}
