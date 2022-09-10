package com.search.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.search.entity.Search;
import com.search.repository.DepartmentRepository;
import com.search.repository.SearchRepository;
import com.search.repository.SearchRepositoryCustom;

@Service
public class SearchService {
	
	@Autowired
	SearchRepository repository;
	
	@Autowired
	SearchRepositoryCustom repositoryCustom;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	
	public List<Search> search(String userId, String userName, Integer deptCd, Date startDate, Date endDate){
		List<Search> result;
		if ("".equals(userId) && "".equals(userName) && 0 == deptCd && startDate == null && endDate == null) {
			result = repository.findAll();
		} else {
			result = repositoryCustom.search(userId, userName, deptCd, startDate, endDate);
		}
		return result;
	}
	

}
