package com.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.search.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	}


