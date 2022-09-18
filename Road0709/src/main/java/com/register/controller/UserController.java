package com.register.controller;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.register.form.RegisterForm;
import com.register.service.UserService;
import com.search.entity.Department;
import com.search.entity.Prefecture;
import com.search.repository.DepartmentRepository;
import com.search.repository.PrefectureRepository;
;
/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {
  /**
   * ユーザー情報 Service
   */
  @Autowired
  private UserService userService;
  

   
  @Autowired
 private PrefectureRepository prefecturerepository;
  
  @Autowired
 private DepartmentRepository departmentrepository;
  
  @Autowired
  PasswordEncoder passwordEncoder;
  
  @GetMapping(value = "/")
  public String displayAdd(Model model) {
    
    return "search";
  }
  
  @RequestMapping(value = "/register")
  public String top(Model model,@ModelAttribute RegisterForm registerForm) {
  
  List<Prefecture> prefecture = prefecturerepository.findAll();
  model.addAttribute("prefecture", prefecture);
 
  List<Department> department = departmentrepository.findAll();
  model.addAttribute("department", department);
  
      return "register";
  }
 
  @RequestMapping("/register_completion")
  public String register_completion(@Validated @ModelAttribute RegisterForm registerForm, BindingResult result, Model model) {
	  if (result.hasErrors()) {
	      // 入力チェックエラーの場合
	      List<String> errorList = new ArrayList<String>();
	      
	      for (ObjectError error : result.getAllErrors()) {
	        errorList.add(error.getDefaultMessage());
	      }
	      model.addAttribute("validationError", errorList);
	      
	      List<Prefecture> prefecture = prefecturerepository.findAll();
	      model.addAttribute("prefecture", prefecture);
	     
	      List<Department> department = departmentrepository.findAll();
	      model.addAttribute("department", department);
	      
	      return "register";
	    }
//	  System.out.println(registerForm.getId());
	  
	  Date date = new Date();
	  registerForm.setEntry_date(date);
	  
	  //パスワードをハッシュ化して登録する
	  registerForm.setPassword(passwordEncoder.encode(registerForm.getPassword()));
	  
	  
	  	// ユーザー情報の登録
	    userService.create(registerForm);
	    
	    
	    
	    registerForm.setPrefecture_name(prefecture_name(registerForm.getPrefecture_code()));
	    
 
	    registerForm.setDepartment_name(department_name(registerForm.getDepartment_code()));
	    
	    
	    model.addAttribute("RegisterForm", registerForm);
	    
	  
	  
	  return "register_completion";
  }
  
  public String prefecture_name(Integer prefecture_code) {
	  
	  String prefecture_name = "";
	  
	   List<Prefecture> prefecture = prefecturerepository.findAll();
	 
	  for(int i=0; prefecture.size()>i;i++) {
	   if(prefecture.get(i).getPrefecture_code() == prefecture_code) {
	    prefecture_name = prefecture.get(i).getPrefecture_name();
	   } 
	  }
	  return prefecture_name;
	 }

  public String department_name(Integer department_code) {
	  String department_name = "";
	  List<Department> department = departmentrepository.findAll();
	  for(int i=0; department.size()>i;i++) {
	   if(department.get(i).getDepartment_code() == department_code) {
	    department_name = department.get(i).getDepartment_name();
	   } 
	  }
	  return department_name;
	 }
  
}



