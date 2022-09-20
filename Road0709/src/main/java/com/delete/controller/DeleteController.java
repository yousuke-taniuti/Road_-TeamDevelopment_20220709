package com.delete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.delete.entity.Delete;
import com.delete.service.DeleteService;
import com.employee.edit.editRequest.EditRequest;
import com.search.repository.User_authRepository;


@Controller
public class DeleteController {

	@Autowired
	private DeleteService deleteService;
	
	@Autowired
	private User_authRepository user_authRepository;
	
	
//	@GetMapping(value = "/serchlist")
//	public String displaylist(Model model){
//		return "serch&list";
//	}
	
	
	@GetMapping(value = "/delete")
	public String displaySerch(EditRequest editRequests,Model model) {
		Delete delete = deleteService.findById(editRequests.getUser_id());
		user_authRepository.deleteById(editRequests.getUser_id());
		deleteService.delete(editRequests.getUser_id());
		model.addAttribute("userDate",delete);
		return "delete";
	}
	
	
}
