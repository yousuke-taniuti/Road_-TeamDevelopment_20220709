package com.employeesignup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employeesignup.entity.employeeSignupEntity;
import com.employeesignup.form.employeeSignupForm;
import com.employeesignup.repository.employeeSignupRepository;
import com.search.entity.User_auth;
import com.search.repository.User_authRepository;

/**
 * ユーザー情報 Serviceuser
	*/
	@Service
	@Transactional(rollbackFor = Exception.class)
	public class employeeSignupService {
	/**
	* * ユーザー情報 UserRepository
	*/
	@Autowired
	private employeeSignupRepository employeeSignuprepository;

	@Autowired
	private User_authRepository user_authRepository;
	/**
	 * ユーザー情報 新規登録
	 * @param user ユーザー情報
	 */
	 public void create(employeeSignupForm employeeSignupform) {
	  employeeSignupEntity employeeSignupentity = new employeeSignupEntity();
		 employeeSignupentity.setUser_id(employeeSignupform.getUser_id());
		 employeeSignupentity.setName(employeeSignupform.getName());	   
		 employeeSignupentity.setName_kana(employeeSignupform.getName_kana());
		 employeeSignupentity.setPassword(employeeSignupform.getPassword());
		 employeeSignupentity.setUpn(employeeSignupform.getUpn());
		 employeeSignupentity.setBirthday(employeeSignupform.getBirthday());
		 employeeSignupentity.setGender(employeeSignupform.getGender());
		 employeeSignupentity.setPrefecture_code(employeeSignupform.getPrefecture_code());
		 employeeSignupentity.setDepartment_code(employeeSignupform.getDepartment_code());
		 employeeSignupentity.setEntry_date(employeeSignupform.getEntry_date());
		employeeSignuprepository.save(employeeSignupentity);
	  
	    User_auth user_auth = new User_auth();
	    	user_auth.setUser_id(employeeSignupform.getUser_id());
	    	user_auth.setRole_code(employeeSignupform.getRole_code());    
	    user_authRepository.save(user_auth);
	  }
	    
}
	