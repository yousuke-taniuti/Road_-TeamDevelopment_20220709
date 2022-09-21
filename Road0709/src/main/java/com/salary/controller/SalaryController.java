package com.salary.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.completed.request.EditCompletedRequest;
import com.salary.entity.Salary;
import com.salary.service.SalaryService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class SalaryController {

	@Autowired
	private SalaryService salaryService;

//	給与画面（ログイン画面できたら）ログイン中のユーザーIDを取得dd
//	@GetMapping("/")
//	public String displayList(@AuthenticationPrincipal User user, Model model) {
//		user.getUser_id();
//		List<Salary> salaryList = salaryService.searchAll();
//		model.addAttribute("salaryList", salaryList);
//		return "salary";
//	}

	@GetMapping("/salary")
	public String displayList(Model model) {
		List<Salary> salaryList = new ArrayList<Salary>();
		List<Salary> salaryListAll = new ArrayList<Salary>();
		salaryListAll = salaryService.searchAll();
		for (int i = 0; salaryListAll.size() > i; i++) {
			if (salaryListAll.get(i).getUser_id() == 1234) { // user.getIdが１のところに来る
				salaryList.add(salaryListAll.get(i));
			}
		}
		model.addAttribute("salaryList", salaryList);
		model.addAttribute("editCompletedRequests", new EditCompletedRequest());
		
		return "salary";
	}
	
//	管理者が給与編集ボタンを押下したときに動く
	@GetMapping("/salary_admin")
	public String displayListt(Model model) {
		List<Salary> salaryList = new ArrayList<Salary>();
		List<Salary> salaryListAll = new ArrayList<Salary>();
		salaryListAll = salaryService.searchAll();
		for (int i = 0; salaryListAll.size() > i; i++) {
			if (salaryListAll.get(i).getUser_id() == 1) { // user.getIdが１のところに来る
				salaryList.add(salaryListAll.get(i));
			}
		}
		model.addAttribute("salaryList", salaryList);
		model.addAttribute("editCompletedRequests", new EditCompletedRequest());
		
		return "html/salary_admin";
	}

////	給与編集画面
//	@PostMapping(path= "salary", params= "salary")
//	 String edit(@RequestParam Integer salary_number, @ModelAttribute Salary salaryForm) {
//        //ポイント3
//        Optional<Salary> salaryOpt = salaryService.findById(salary_number);
//        //ポイント4
//        Salary salary = salaryOpt.get();
//        //ポイント5
//        BeanUtils.copyProperties(salary, salaryForm);
//        return "html/salary_s";
//    }
	


////	検索＆一覧
//	@GetMapping("/searchList")
//	public String getSerch() {
//		return "search";
//	}

}


