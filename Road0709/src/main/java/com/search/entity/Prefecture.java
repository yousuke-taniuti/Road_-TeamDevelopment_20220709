package com.search.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="prefecture")
@Getter
@Setter

public class Prefecture {
     
	@Id
	@Column(name="prefecture_code")
	private Integer prefecture_code;
 
	@Column(name="prefecture_name")
	private String prefecture_name;
 
}
