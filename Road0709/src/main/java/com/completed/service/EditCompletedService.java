package com.completed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.completed.entity.EditCompleted;
import com.completed.repository.EditCompletedRepository;
import com.completed.request.EditCompletedRequest;

@Service
public class EditCompletedService {
	

	@Autowired
	private EditCompletedRepository editCompletedRepository;
	
	
	
	public EditCompleted findById(String salaryNumber) {
		EditCompleted findId = editCompletedRepository.findById(salaryNumber).get();
		return findId;
	}
	
	
	public void update(EditCompletedRequest editCompletedRequest) {
		EditCompleted editCompleted = findById(editCompletedRequest.getSalaryNumber());
		editCompleted.setName(editCompletedRequest.getName());
		editCompleted.setBaseSalary(editCompletedRequest.getBaseSalary());
		editCompleted.setTax(editCompletedRequest.getTax());
		editCompleted.setPremium(editCompletedRequest.getPremium());
		editCompleted.setCarfare(editCompletedRequest.getCarfare());
		editCompleted.setGrossPayment(editCompletedRequest.getGrossPayment());
//		editCompleted.setSalaryDate(editCompletedRequest.getSalaryDate());
		editCompletedRepository.save(editCompleted);
	}
	

}

	

