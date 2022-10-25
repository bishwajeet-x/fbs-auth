package com.flightapp.service;

import java.util.List;

import com.flightapp.entity.Role;
import com.flightapp.entity._User;

public interface UserService {
	_User saveUser(_User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	_User getUser(String username);
	List<_User> getUsers();
}
