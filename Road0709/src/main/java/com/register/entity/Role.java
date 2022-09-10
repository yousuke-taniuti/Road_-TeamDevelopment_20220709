package com.register.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="role")
@Getter
@Setter

public class Role {
	
	
	@Id
	@Column(name="role_code")
	private String role_code;
	
	@Column(name="role_name")
	private String role_name;
	

}
