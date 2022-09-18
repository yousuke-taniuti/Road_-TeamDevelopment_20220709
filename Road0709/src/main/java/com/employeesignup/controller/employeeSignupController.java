package com.employeesignup.controller;

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

import com.employeesignup.form.employeeSignupForm;
import com.employeesignup.service.employeeSignupService;
import com.search.entity.Department;
import com.search.entity.Prefecture;
import com.search.entity.Role;
import com.search.repository.DepartmentRepository;
import com.search.repository.PrefectureRepository;
import com.search.repository.RoleRepository;


	@Controller
	public class employeeSignupController {
  
	@Autowired
	private employeeSignupService employeeSignupservice;
   
	@Autowired
	private PrefectureRepository prefecturerepository;
  
	@Autowired
	private DepartmentRepository departmentrepository;
	
	@Autowired
	private RoleRepository rolerepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping(value = "/serchLlist")
	public String displayAdd(Model model) {
    
    return "search";
  }
  
	@GetMapping(value = "/new_regist")
	public String top(Model model) {
		model.addAttribute("employeeSignupForm", new employeeSignupForm());
  
		List<Prefecture> prefecture = prefecturerepository.findAll();
		model.addAttribute("prefecture", prefecture);
		List<Department> department = departmentrepository.findAll();
		model.addAttribute("department", department);
		List<Role> role = rolerepository.findAll();
	    model.addAttribute("role", role);
  
	    return "new_regist";
	}
 
	@RequestMapping("/employee_registration")
	public String register_completion(@Validated @ModelAttribute employeeSignupForm employeeSignupform, BindingResult result, Model model) {
	  if (result.hasErrors()) {
	      // 入力チェックエラーの場合
	      List<String> errorList = new ArrayList<String>();
	      
	      for (ObjectError error : result.getAllErrors()) {
	    	  errorList.add(error.getDefaultMessage());
	      	}
	      model.addAttribute("employeeSignupForm", employeeSignupform);
	      model.addAttribute("validationError", errorList);
	      
	      List<Prefecture> prefecture = prefecturerepository.findAll();
	      model.addAttribute("prefecture", prefecture);
	      List<Department> department = departmentrepository.findAll();
	      model.addAttribute("department", department);
	      List<Role> role = rolerepository.findAll();
	      model.addAttribute("role", role);
	      return "new_regist";
	    }
	  
	  Date date = new Date();
	  employeeSignupform.setEntry_date(date);
	  
	  //パスワードをハッシュ化して登録する
	  employeeSignupform.setPassword(passwordEncoder.encode(employeeSignupform.getPassword()));
	  
	  	// ユーザー情報の登録
	  employeeSignupservice.create(employeeSignupform);
	  
	  employeeSignupform.setPrefecture_name(prefecture_name(employeeSignupform.getPrefecture_code()));
	  
	  employeeSignupform.setDepartment_name(department_name(employeeSignupform.getDepartment_code()));
	  
	  
	  
	  employeeSignupform.setRole_name(role_name(employeeSignupform.getRole_code()));
	    
	  model.addAttribute("employeeSignupForm", employeeSignupform);
	    
	  return "employee_registration";
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
  
  public String role_name(String role_code) {
	  String role_name = "";
	  	List<Role> role = rolerepository.findAll();
	  for(int i=0; role.size()>i;i++) {
		  if(role.get(i).getRole_code().equals(role_code)) {
			  role_name = role.get(i).getRole_name();
		  		} 
	  		}
	  	return role_name;
	 }
  
}