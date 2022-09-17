package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.register.entity.Employee;


@Repository
public interface LoginRepository extends JpaRepository<Employee , String> {  
}
