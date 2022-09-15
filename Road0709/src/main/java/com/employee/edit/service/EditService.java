package com.employee.edit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.edit.editRequest.EditRequest;
import com.employee.edit.entity.Edit;
import com.employee.edit.repository.EditRepository;
@Service
public class EditService {
 
	@Autowired
	private EditRepository editRepository;
	
	  public List<Edit> searchAll() {
		    return editRepository.findAll();
		  }


	public Edit findById(String user_id) {
		return editRepository.findById(user_id).get();
	}
	/**
	 * ユーザー情報 更新s
	 * 
	 * @param user ユーザー情報
	 * @return
	 */
	public void update(EditRequest editRequest) {
		
		Edit edit = findById(editRequest.getUser_id());
		edit.setName(editRequest.getName());
		edit.setName_kana(editRequest.getName_kana());
		edit.setPassword(editRequest.getPassword());
		edit.setUpn(editRequest.getUpn());
		edit.setBirthday(editRequest.getBirthday());
		edit.setGender(editRequest.getGender());
//		edit.setRole_code(editRequest.getRole_code());
		edit.setPrefecture_code(editRequest.getPrefecture_code());
		edit.setDepartment_code(editRequest.getDepartment_code());
		edit.setEntry_date(editRequest.getEntry_date());
//		edit.setProfile_image(editRequest.getProfile_image());
		editRepository.save(edit);

	}
	
	  public void delete(String user_id) {
		    Edit edit = findById(user_id);
		    editRepository.delete(edit);
		  }
}
