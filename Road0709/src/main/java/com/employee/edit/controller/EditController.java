package com.employee.edit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.edit.editRequest.EditRequest;
import com.employee.edit.entity.Edit;
import com.employee.edit.service.EditService;
import com.search.entity.Department;
import com.search.entity.Prefecture;
import com.search.repository.DepartmentRepository;
import com.search.repository.PrefectureRepository;

@Controller
public class EditController {

	@Autowired
	private EditService editService;

	@Autowired
	private PrefectureRepository prefecturerepository;

	@Autowired
	private DepartmentRepository departmentrepository;

	@GetMapping(value = "/edit/update/s&l")
	public String index(Model model) {
		EditRequest editRequest = new EditRequest();
		model.addAttribute("editRequest", editRequest);
		return "search";
	}
//	

////	（ログイン画面できたら）ログイン中のユーザーIDを取得                                                                                  
//	@GetMapping("/")                                                                           
//	public String displayList(@AuthenticationPrincipal User user, Model model) {                                 
//		user.getUser_id();                                                                                       
//		List<Edit> editList = editService.searchAll();                                                           
//		model.addAttribute("editList", editList);                                                                
//		return "html/edit";                                                                                      
//	}                                                                                                            
//                                                                                                               
	/**
	 * ユーザー編集画面を表示
	 * 
	 * @param id    表示するユーザーID
	 * @param model Model
	 * @return ユーザー編集画面
	 */
	@GetMapping(value = "/edit")
	public String displayEdit(EditRequest editRequests, Model model) {
		Edit edit = editService.findById(editRequests.getUser_id());
		EditRequest editRequest = new EditRequest();
		editRequest.setUser_id(edit.getUser_id());
		editRequest.setName(edit.getName());
		editRequest.setName_kana(edit.getName_kana());
		editRequest.setPassword(edit.getPassword());
		editRequest.setUpn(edit.getUpn());
		editRequest.setGender(edit.getGender());
		editRequest.setBirthday(edit.getBirthday());
//		editRequest.setRole_code(edit.getRole_code());                                                           
		editRequest.setPrefecture_code(edit.getPrefecture_code());
		editRequest.setDepartment_code(edit.getDepartment_code());
		editRequest.setEntry_date(edit.getEntry_date());
		
		List<Prefecture> prefecture = prefecturerepository.findAll();
		  model.addAttribute("prefecture", prefecture);
		
		List<Department> department = departmentrepository.findAll();
		  model.addAttribute("department", department);
//		List<Edit> editList = editService.findAll();                                                             
		model.addAttribute("editRequest", editRequest);
		return "edit";
	}

	@RequestMapping(value = "/edit/update", method = RequestMethod.POST)
	public String update(@Validated @ModelAttribute EditRequest editRequest, BindingResult result, Model model) {

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

			return "edit";
		}
		
		

		editService.update(editRequest);

		model.addAttribute("editRequest", editRequest);

		return "editcomplete";

	}

	public String prefecture_name(Integer prefecture_code) {

		String prefecture_name = "";

		List<Prefecture> prefecture = prefecturerepository.findAll();

		for (int i = 0; prefecture.size() > i; i++) {
			if (prefecture.get(i).getPrefecture_code() == prefecture_code) {
				prefecture_name = prefecture.get(i).getPrefecture_name();
			}
		}
		return prefecture_name;
	}

	public String department_name(Integer department_code) {
		String department_name = "";
		List<Department> department = departmentrepository.findAll();
		for (int i = 0; department.size() > i; i++) {
			if (department.get(i).getDepartment_code() == department_code) {
				department_name = department.get(i).getDepartment_name();
			}
		}
		return department_name;
	}
}
