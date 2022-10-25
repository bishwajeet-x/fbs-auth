package com.flightapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	Role findByName(String rolename);
}
	