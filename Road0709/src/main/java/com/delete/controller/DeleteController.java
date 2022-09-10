package com.delete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.delete.entity.Delete;
import com.delete.service.DeleteService;


@Controller
public class DeleteController {

	@Autowired
	private DeleteService deleteService;
	
	
	@GetMapping(value = "/serch&list")
	public String displaylist(Model model){
		return "serch&list";
	}
	
	
	@GetMapping(value = "/{user_id}")
	public String displaySerch(@PathVariable String user_id,Model model) {
		Delete delete = deleteService.findById(user_id);
		deleteService.delete(user_id);
		model.addAttribute("userDate",delete);
		return "delete";
	}
	
	
}
