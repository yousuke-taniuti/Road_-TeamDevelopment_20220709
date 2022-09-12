package com.employee.edit.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.edit.editRequest.EditRequest;
import com.employee.edit.entity.Edit;
import com.employee.edit.repository.EditRepository;

public class EditService {
 
	@Autowired
	private EditRepository editRepository;

	public Edit findById(String user_id) {
		Edit findId = editRepository.findById(user_id).get();
		return findId;
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

}
