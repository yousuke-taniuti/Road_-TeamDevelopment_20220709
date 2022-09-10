package com.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
