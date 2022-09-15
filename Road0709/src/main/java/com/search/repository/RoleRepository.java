package com.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.search.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
	
}