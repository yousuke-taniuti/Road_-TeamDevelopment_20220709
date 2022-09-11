package com.search.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="department")
@Getter
@Setter
public class Department {
	
	@Column(name="office_code")
	private Integer office_code;
		
	@Id
	@Column(name="department_code")
	private Integer department_code;
	
	@Column(name="department_name")
	private String department_name;
}