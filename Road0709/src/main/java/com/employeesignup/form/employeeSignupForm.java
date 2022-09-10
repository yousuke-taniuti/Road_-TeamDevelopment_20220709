package com.employeesignup.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class employeeSignupForm  {
		
	@NotEmpty(message = "IDを入力してください")
	private String user_id;
		
	@NotEmpty(message = "名前を入力してください")
	private String name;
	
	@NotEmpty(message = "カタカナで入力してください")
	private String name_kana;
		
	@NotEmpty(message = "passwordを入力してください")
	private String password;
		
	@NotEmpty(message = "メールアドレスを入力してください")
	private String upn;
		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  Date birthday;
		
	@NotNull(message = "性別を入力してください")
	private Integer gender;
	
	private Integer prefecture_code;
		
	private Integer department_code;
	    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  Date entry_date;
	    
	private String prefecture_name;

	private String department_name;

	private String role_code;
	
	private String role_name;
}
