package com.completed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.completed.entity.EditCompleted;
import com.completed.repository.EditCompletedRepository;
import com.completed.request.UpdateRequest;

@Service
public class EditCompletedService {

	@Autowired
	private EditCompletedRepository editCompletedRepository;
	
	public EditCompleted findById(Long userId) {
		return editCompletedRepository.findById(userId).get();
	}
	
	
	public void update(UpdateRequest updateRequest) {
		EditCompleted editCompleted = findById(updateRequest.getSalaryNumber());
		editCompleted.setName(updateRequest.getName());
		editCompleted.setBaseSalary(updateRequest.getBaseSalary());
		editCompleted.setTax(updateRequest.getTax());
		editCompleted.setPremium(updateRequest.getPremium());
		editCompleted.setCarfare(updateRequest.getCarfare());
		editCompleted.setGrossPayment(updateRequest.getGrossPayment());
		editCompleted.setSalaryDate(updateRequest.getSalaryDate());
		editCompletedRepository.save(editCompleted);
	}
	
}
