package com.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.register.entity.User_auth;

@Repository
public interface User_authRepository extends JpaRepository<User_auth,String> {

}
