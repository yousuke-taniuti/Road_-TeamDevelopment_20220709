package com.delete.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delete.entity.Delete;
import com.delete.repository.DeleteRepository;

@Service
public class DeleteService {
	
	@Autowired
	private DeleteRepository deleteRepository;

	public Delete findById(String user_id) {
		return deleteRepository.findById(user_id).get();
	}

	 public void delete(String user_id) {
		    Delete delete = findById(user_id);
		    deleteRepository.delete(delete);
	 }
	
}
