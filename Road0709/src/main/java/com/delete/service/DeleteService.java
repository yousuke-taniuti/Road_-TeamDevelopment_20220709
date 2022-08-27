package com.delete.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delete.entity.Delete;
import com.delete.repository.DeleteRepository;

@Service
public class DeleteService {
	
	@Autowired
	private DeleteRepository deleteRepository;

	public Delete findById(Long userId) {
		return deleteRepository.findById(userId).get();
	}

	 public void delete(Long userId) {
		    Delete delete = findById(userId);
		    deleteRepository.delete(delete);
	 }
	
}
