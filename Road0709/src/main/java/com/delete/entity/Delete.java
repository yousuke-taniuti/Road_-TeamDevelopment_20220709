package com.delete.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Delete implements Serializable{
	
	@Id
	private String user_id;
	
	
	private String name;
	
	
	private String name_kana;
	
	
	private String password;

	
	private String upn;
	
	
	private Date birthday;
	
	
	private int gender;
	
	
	private int prefecture_code;
	
	
	private int department_code;
	
	
	private Date entry_date;
	
	
//	@Nullable
//	@Column(name = "profile_image")
//	private byte profile_image;
//	
	
}
