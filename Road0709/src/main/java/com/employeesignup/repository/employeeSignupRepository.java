package com.employeesignup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeesignup.entity.employeeSignupEntity;
/**
 * ユーザー情報 Repository
 */
@Repository
public interface employeeSignupRepository extends JpaRepository<employeeSignupEntity, String> {
	
}