package com.delete.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Delete implements Serializable{
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String user_id;
	
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "name_kana")
	private String name_kana;
	
	
	@Column(name = "password")
	private String password;

	
	@Column(name = "upn")
	private String upn;
	
	
	@Column(name = "birthday")
	private Date birthday;
	
	
	@Column(name = "gender")
	private int gender;
	
	
	@Column(name = "prefecture_code")
	private int prefecture_code;
	
	
	@Column(name = "department_code")
	private int department_code;
	
	
	@Column(name = "entry_date")
	private Date entry_date;
	
	
//	@Nullable
//	@Column(name = "profile_image")
//	private byte profile_image;
//	
	
}
