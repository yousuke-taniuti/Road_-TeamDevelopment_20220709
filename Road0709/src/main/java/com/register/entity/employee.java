package com.register.entity;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class employee {
 private static void  init(Model model) {
 
		        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		        //Principalからログインユーザの情報を取得
		        String userId = auth.getName();
		        model.addAttribute("userId", userId);
 }
 //DBの値保存のためのフィールド変数
	private String user_id;
	private String name;
	private String name_kana;
	private String password;
	private String upn;
	private Date birthday;
	private Integer gender;
	private Integer prefecture_code;
	private Integer department_code;
	private Date entry_date;
	private Byte profile_image;
	
	{

	
	 
	 
	 
	 
	
	}
	}
