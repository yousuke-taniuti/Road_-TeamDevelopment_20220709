package com.delete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delete.entity.Delete;


@Repository
public interface DeleteRepository extends JpaRepository<Delete, String> {

}
	
