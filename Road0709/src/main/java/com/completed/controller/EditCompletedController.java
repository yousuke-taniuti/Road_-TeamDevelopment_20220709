package com.completed.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.completed.entity.EditCompleted;
import com.completed.request.UpdateRequest;
import com.completed.service.EditCompletedService;


@Controller
public class EditCompletedController {

	@Autowired
	private EditCompletedService editCompletedService;
	
	
	@GetMapping(value = "/html/{user_id}/salary")
	public String displaySalary(@PathVariable Long userId,Model model) {
		return "/html/salary";
	}
	
	
	@GetMapping(value = "/html/{salary_number}/{user_id}/salary_s")
	public String displaySalarys(@PathVariable Long userId,@PathVariable Long salaryNumber,Model model) {
		EditCompleted editCompleted = editCompletedService.findById(salaryNumber);
		UpdateRequest updateRequest = new UpdateRequest();
	    updateRequest.setUserId(editCompleted.getUserId());
	    updateRequest.setName(editCompleted.getName());
	    updateRequest.setBaseSalary(editCompleted.getBaseSalary());
	    updateRequest.setTax(editCompleted.getTax());
	    updateRequest.setPremium(editCompleted.getPremium());
	    updateRequest.setCarfare(editCompleted.getCarfare());
	    updateRequest.setGrossPayment(editCompleted.getGrossPayment());
	    updateRequest.setSalaryDate(editCompleted.getSalaryDate());
	    model.addAttribute("updateRequest", updateRequest);
        return "/html/salary_s";
		
	}
	
	 @RequestMapping(value = "/html/update", method = RequestMethod.POST)
	  public String update(@Validated @ModelAttribute UpdateRequest updateRequest, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	
	      List<String> errorList = new ArrayList<String>();
	      for (ObjectError error : result.getAllErrors()) {
	        errorList.add(error.getDefaultMessage());
	      }
	      model.addAttribute("validationError", errorList);
	      return "/html/salary_s";
	    }
	    // ユーザー情報の登録
	    editCompletedService.update(updateRequest);
	    return "/html/edit";
	  }
	
	
}
