package com.search.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.search.entity.Department;
import com.search.entity.Prefecture;
import com.search.entity.Search;
import com.search.entity.User_auth;
import com.search.form.SearchForm;
import com.search.form.SearchForm2;
import com.search.repository.DepartmentRepository;
import com.search.repository.PrefectureRepository;
import com.search.repository.User_authRepository;
import com.search.service.SearchService;


@ComponentScan
@Controller
public class SearchController {
	
	@Autowired
	public SearchService service;
	
	@Autowired
    private PrefectureRepository prefecturerepository;
	
	@Autowired
    private DepartmentRepository departmentrepository;
	
	@Autowired
    private User_authRepository user_authrepository;
	
	@GetMapping("/searchList")
	public String displayList(Model model) {
		
		List<Prefecture> prefecturere = prefecturerepository.findAll();
		model.addAttribute("prefecturere", prefecturere);

		List<Department> department = departmentrepository.findAll();
		model.addAttribute("department", department);
		
		return "search";
	}
	
	@RequestMapping(value="/search＆list",method = RequestMethod.POST)
	public String login(Model model,@ModelAttribute SearchForm searchForm){
		model.addAttribute("userId", searchForm.getUserId());
		model.addAttribute("userName", searchForm.getUserName());
		model.addAttribute("deptCd", searchForm.getDeptCd());
		model.addAttribute("startDate", searchForm.getStartDate());
		model.addAttribute("endDate", searchForm.getEndDate());
		List<Search> result = service.search(searchForm.getUserId(), searchForm.getUserName(), searchForm.getDeptCd(), searchForm.getStartDate(), searchForm.getEndDate());
		
		List<SearchForm2> result1 = new ArrayList<SearchForm2>();
		
		for(int i=0; result.size()>i;i++) {
			SearchForm2 searchForm2 = new SearchForm2();
			searchForm2.setUserId(result.get(i).getUserId());
			searchForm2.setUserName(result.get(i).getUserName());
			searchForm2.setName_kana(result.get(i).getName_kana());
			searchForm2.setBirthday(result.get(i).getBirthday());
			searchForm2.setGender(result.get(i).getGender());
			searchForm2.setPrefecture_code(result.get(i).getPrefecture_code());
			searchForm2.setPrefecture_name(prefecture_name(result.get(i).getPrefecture_code()));
			searchForm2.setDeptCd(result.get(i).getDeptCd());
			searchForm2.setDepartment_name(department_name(result.get(i).getDeptCd()));
			searchForm2.setEntry_date(result.get(i).getEntry_date());
			
			result1.add(searchForm2);
		}
		
		model.addAttribute("result1", result1);
		model.addAttribute("result1Size", result1.size());
		
		List<Prefecture> prefecture = prefecturerepository.findAll();
		model.addAttribute("prefecture", prefecture);

		List<Department> department = departmentrepository.findAll();
		model.addAttribute("department", department);
		
		List<User_auth> role_code = user_authrepository.findAll();
		model.addAttribute("user_auth", role_code);
		
		
		model.addAttribute("userrole", "CEO");
		
		return "search";
		
	}
	
	public String prefecture_name(Integer integer) {
	String prefecture_name = "";
		 List<Prefecture> prefecture = prefecturerepository.findAll();
		for(int i=0; prefecture.size()>i;i++) {
			if(prefecture.get(i).getPrefecture_code() == integer) {
				prefecture_name = prefecture.get(i).getPrefecture_name();
			}	
		}
		return prefecture_name;
	}
	public String department_name(Integer integer) {
	String department_name = "";
		List<Department> department = departmentrepository.findAll();
		for(int i=0; department.size()>i;i++) {
			if(department.get(i).getDepartment_code() == integer) {
				department_name = department.get(i).getDepartment_name();
			}	
		}
		return department_name;
	}
	
	public String role_code(String userId) {
		String role_code = "";
			List<User_auth> user_auth = user_authrepository.findAll();
			for(int i=0; user_auth.size()>i;i++) {
				if(user_auth.get(i).getUser_id().equals(userId)) {
					role_code = user_auth.get(i).getRole_code();
				}	
			}
			return role_code;
		}	
	
}