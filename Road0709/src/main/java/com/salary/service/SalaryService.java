package com.salary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salary.entity.Salary;
import com.salary.repository.SalaryRepository;

/**
 * ユーザー情報 Service
 */
@Service
public class SalaryService {
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private SalaryRepository salaryRepository;
	
	  /**
	   * ユーザー情報 全検索
	   * @return 検索結果
	   */
	public   List<Salary> searchAll() {
		return salaryRepository.findAll();
	}
	
	/**
	   * ユーザー情報 主キー検索s
	   * @return 検索結果
	   */  public  Salary findById(String user_id) {
	    return salaryRepository.findById(user_id).get();
	  }
	
}

  