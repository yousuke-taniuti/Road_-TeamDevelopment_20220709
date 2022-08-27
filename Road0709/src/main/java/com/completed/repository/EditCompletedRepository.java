package com.completed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.completed.entity.EditCompleted;


@Repository
public interface EditCompletedRepository extends JpaRepository<EditCompleted, Long>{

}
