package com.hrms.gateservice.services;

import java.util.List;

import com.hrms.gateservice.domain.User;

public interface UserService{
    public List<User> findAll();
	public User save(User u);
	public void deleteUserById(long uId);
	public User findById(long uId);
	public User findByName(String userName);
}
