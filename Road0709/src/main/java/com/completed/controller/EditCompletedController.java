package com.completed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.completed.entity.EditCompleted;
import com.completed.request.EditCompletedRequest;
import com.completed.service.EditCompletedService;


@Controller
public class EditCompletedController {

	@Autowired
	private EditCompletedService editCompletedService;
	
	@GetMapping(value = "/index")
	public String index(Model model) {
		EditCompletedRequest editCompletedRequest = new EditCompletedRequest();
		model.addAttribute("editCompletedRequest", editCompletedRequest);
		return "salary";
	}
	
	
	//編集画面
	@GetMapping(value = "/salary_s")
		public String displaySalarys(EditCompletedRequest editCompletedRequests,Model model) {
			EditCompleted editCompleted = editCompletedService.findById(editCompletedRequests.getSalaryNumber());
			EditCompletedRequest editCompletedRequest = new EditCompletedRequest();
			editCompletedRequest.setUserId(editCompleted.getUserId());
			editCompletedRequest.setSalaryNumber(editCompleted.getSalaryNumber());
			editCompletedRequest.setName(editCompleted.getName());
			editCompletedRequest.setBaseSalary(editCompleted.getBaseSalary());
			editCompletedRequest.setTax(editCompleted.getTax());
			editCompletedRequest.setPremium(editCompleted.getPremium());
			editCompletedRequest.setCarfare(editCompleted.getCarfare());
			editCompletedRequest.setGrossPayment(editCompleted.getGrossPayment());
//			editCompletedRequest.setSalaryDate(editCompleted.getSalaryDate());
		    model.addAttribute("editCompletedRequest", editCompletedRequest);
	        return "salary_s";
		
	}
	
//	@RequestMapping(value = "/salary_completed", method = RequestMethod.POST)
//    public String update(Model model) {
//        return "salary_completed";
//    }
	//編集完了画面遷移
	 @RequestMapping(value = "/salary_s/update", method = RequestMethod.POST)
	  public String update(@Validated @ModelAttribute EditCompletedRequest editCompletedRequest, BindingResult result, Model model) {
//	    if (result.hasErrors()) {
//	    	
//	      List<String> errorList = new ArrayList<String>();
//	      for (ObjectError error : result.getAllErrors()) {
//	        errorList.add(error.getDefaultMessage());
//	      }
//	      model.addAttribute("validationError", errorList);
//	      return "salary_s"; 
//		 }
		 //ユーザー情報の登録
	    editCompletedService.update(editCompletedRequest);
	    
	    model.addAttribute("UpdateRequest", editCompletedRequest);
	    
	    return "salary_completd";
	  }
	
	
}
