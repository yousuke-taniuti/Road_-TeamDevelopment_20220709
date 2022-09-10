package com.salary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salary.entity.Salary;
/**
 * ユーザー情報 Repository
 */
@Repository
public interface SalaryRepository extends JpaRepository<Salary, String> {}
