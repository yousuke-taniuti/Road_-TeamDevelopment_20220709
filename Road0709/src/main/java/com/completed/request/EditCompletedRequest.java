package com.completed.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper=false)
@Data
public class EditCompletedRequest implements Serializable {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String salaryNumber;
	
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
	
//	@Nullable
//	private Date salaryDate;

}


