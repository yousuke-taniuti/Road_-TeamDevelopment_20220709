package com.search.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="employee")
@Getter
@Setter
public class Search {
	
	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="name")
	private String userName;
	
	@Column(name="name_kana")
	private String name_kana;

	@Column(name="birthday")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	@Column(name="gender")
	private Integer gender;

	@Column(name="prefecture_code")
	private Integer prefecture_code;
	
	@Column(name="department_code")
	private Integer deptCd;
	
	@NotNull
	@Column(name="entry_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entry_date;
	
}
