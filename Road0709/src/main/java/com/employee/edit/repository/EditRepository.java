package com.employee.edit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.edit.entity.Edit;


/**
 * ユ－ーザー情報 Repository
 */
@Repository
public interface EditRepository extends JpaRepository<Edit, String> {}

