package com.register.service;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.register.entity.User;
import com.register.form.RegisterForm;
import com.register.repository.UserRepository;
import com.search.entity.User_auth;
import com.search.repository.User_authRepository;

	/**
	 * ユーザー情報 Serviceuser
	 */
	@Service
	@Transactional(rollbackFor = Exception.class)
	public class UserService {
	  /**
	   * ユーザー情報 UserRepository
	   */
	  @Autowired
	  private UserRepository userRepository;
	  
//	  /**
//	   * ユーザー情報 RoleRepository
//	   */
//	  @Autowired
//	  private RoleRepository roleRepository;
	  
//	  
      @Autowired
      private User_authRepository user_authRepository;
	  /**
	   * ユーザー情報 新規登録
	   * @param user ユーザー情報
	   */
	  public void create(RegisterForm registerForm) {
	  
	    User user = new User();
	    user.setUser_id(registerForm.getUser_id());
	    user.setName(registerForm.getName());	   
	    user.setName_kana(registerForm.getName_kana());
	    user.setPassword(registerForm.getPassword());
	    user.setUpn(registerForm.getUpn());
	    user.setBirthday(registerForm.getBirthday());
	    user.setGender(registerForm.getGender());
	    user.setPrefecture_code(registerForm.getPrefecture_code());
	    user.setDepartment_code(registerForm.getDepartment_code());
	    user.setEntry_date(registerForm.getEntry_date());
	    userRepository.save(user);
	  
	    User_auth user_auth = new User_auth();
	    user_auth.setUser_id(registerForm.getUser_id());
	    user_auth.setRole_code("S");    
	    user_authRepository.save(user_auth);
	  }
    
	  }
	