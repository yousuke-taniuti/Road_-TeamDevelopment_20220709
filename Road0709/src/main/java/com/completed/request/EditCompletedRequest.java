package com.completed.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data
public class EditCompletedRequest implements Serializable {

	@NotEmpty(message = "名前を入力してください")
	@Size(max = 50,message = "名前は50桁以内で入力してください")
	private String name;
	
	@Nullable
	private int baseSalary;
	
	@Nullable
	private int tax;
	
	@Nullable
	private int premium;
	
	@Nullable
	private int carfare;
	
	@Nullable
	private int grossPayment;
	
	@Nullable
	private Date salaryDate;
}
