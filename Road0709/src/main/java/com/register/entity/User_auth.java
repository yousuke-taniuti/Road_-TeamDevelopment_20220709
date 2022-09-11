package com.register.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user_auth")
@Getter
@Setter

public class User_auth{
	
	
	@Id
	@Column(name="user_id")
	private String user_id;
	
	
	@Column(name="role_code")
	private String role_code;
}
