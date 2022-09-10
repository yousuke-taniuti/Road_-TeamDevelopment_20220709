package com.salary.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "salary")
public class Salary implements Serializable {
	/**
	 * ユーザーID
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer user_id;
	/**
	 *  給与ナンバー
	 */
	@Id
	@Column(name = "salary_number")
	private String salary_number;
	/**
	 *名前
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 給与
	 */
	@Column(name = "base_salary")
	private String base_salary;
	/**
	 * 税
	 */
	@Column(name = "tax")
	private String tax;
	/**
	 * 保険料
	 */
	@Column(name = "premium")
	private String premium;
	/**
	 * 交通費
	 */
	@Column(name = "carfare")
	private String carfare;
	/**
	 * 総支給額
	 */
	@Column(name = "gross_payment")
	private String gross_payment;
	/**
	 * 交付日s
	 */
	@Column(name = "salary_date")
	private String salary_date;
}	



