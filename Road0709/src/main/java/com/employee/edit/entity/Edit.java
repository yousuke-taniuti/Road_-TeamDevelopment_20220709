package com.employee.edit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報d Entity
 */
@Entity
//@Embeddable
@Data
@Table(name = "employee")
public class Edit implements Serializable{
	/**
	 * ID
	 */
	@Id
	@Column(name = "user_id")
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String user_id;
	/**
	 * 名前
	 */
	@Column(name = "name")
	private String name;
	/**
	 * カナ
	 */
	@Column(name = "name_kana")
	private String name_kana;
	/**
	 * パスワード
	 */
	@Column(name = "password")
	@Getter
	@Setter
	private String password;
	/**
	 * メールアドレス
	 */
	@Column(name = "upn")
	private String upn;
	/**
	 * 生年月日
	 */
	@Column(name = "birthday")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	/**
	 * 性別
	 */
	@Column(name = "gender")
	private Integer gender;

	@Column(name = "prefecture_code")
	private Integer prefecture_code;

	@Column(name = "department_code")
	private Integer department_code;

	@Column(name = "entry_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entry_date;

}