package com.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.entity.Role;



public interface RoleRepository extends JpaRepository<Role, String> {
	

}