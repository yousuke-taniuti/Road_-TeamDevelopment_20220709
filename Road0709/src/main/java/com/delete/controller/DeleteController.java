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
	
	@GetMapping(value = "/html/{user_id}")
	public String displaySerch(@PathVariable Long userId,Model model) {
		Delete delete = deleteService.findById(userId);
		model.addAttribute("userDate",delete);
		return "/html/edit";
	}
	
	
	 @GetMapping("/user/{id}/delete")
	  public String delete(@PathVariable Long userId, Model model) {
	    deleteService.delete(userId);
	    return "redirect:/user/serch&list";
	 }
	
	
}
