package com.employee.edit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.edit.editRequest.EditRequest;
import com.employee.edit.entity.Edit;
import com.employee.edit.service.EditService;

@Controller
public class EditController {

	@Autowired
	private EditService editService;

	@GetMapping(value = "/edit/update/s&l")
	public String index(Model model) {
		EditRequest editRequest = new EditRequest();
		model.addAttribute("editRequest", editRequest);
		return "search";
	}

//	（ログイン画面できたら）ログイン中のユーザーIDを取得
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
		editRequests.setUser_id("1");
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
//		List<Edit> editList = editService.findAll();
		model.addAttribute("editRequest", editRequest);
		return "edit";
	}

	@RequestMapping(value = "/edit/update", method = RequestMethod.POST)
	public String update(@Validated @ModelAttribute EditRequest editRequest, BindingResult result, Model model) {

		editService.update(editRequest);

		model.addAttribute("UpdateRequest", editRequest);

		return "editcomplete";
//	  @RequestMapping("/")
//	  public String update(@Valid EditRequest editRequest, BindingResult bindingResult) {
//		  
//	    if (bindingResult.hasErrors()) {
//	    
//	      return "html/edit";
//	    }
//	    
//	    // ユーザー情報の更新
//	    
//	    return "redirect:/editcomplete";
//	  }
//	  

	}

}
