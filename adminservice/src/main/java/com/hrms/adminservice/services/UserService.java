package com.hrms.adminservice.services;

import java.util.List;

import com.hrms.adminservice.domain.User;

public interface UserService{
    public List<User> findAll();
	public User save(String name, String email, String pwd);
	public void deleteUserById(long uId);
	public User findById(long uId);
	public User findByName(String userName);
}
