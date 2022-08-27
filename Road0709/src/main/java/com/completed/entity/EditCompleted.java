package com.completed.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "salary")
public class EditCompleted implements Serializable{

	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	
	@Id
	@Column(name = "salary_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long salaryNumber;
	
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "base_salary")
	private int baseSalary;
	
	
	@Column(name = "tax")
	private int tax;
	
	
	@Column(name = "premium")
	private int premium;
	
	
	@Column(name = "carfare")
	private int carfare;
	
	
	@Column(name = "gross_payment")
	private int grossPayment;
	
	
	@Column(name = "salary_date")
	private Date salaryDate;
	
	
}
