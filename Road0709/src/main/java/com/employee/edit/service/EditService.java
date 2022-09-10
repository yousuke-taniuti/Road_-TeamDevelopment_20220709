package com.employee.edit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.edit.entity.Edit;
import com.employee.edit.repository.EditRepository;
import com.employee.edit.request.EditRequest;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EditService {
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private EditRepository editRepository;

//  /**
//   * ユーザー情報 全検索
//   * @return 検索結果
//   */
//  public List<Edit> findAll() {
//    return editRepository.findAll();
//  }
	/**
	 * ユーザー情報 主キー検索
	 * 
	 * @return 検索結果
	 */
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
//    edit.setUser_id(editRequest.getUser_id());
		edit.setName(editRequest.getName());
		edit.setName_kana(editRequest.getName_kana());
		edit.setPassword(editRequest.getPassword());
		edit.setUpn(editRequest.getUpn());
		edit.setBirthday(editRequest.getBirthday());
		edit.setRole_code(editRequest.getRole_code());
		edit.setPrefecture_code(editRequest.getPrefecture_code());
		edit.setDepartment_code(editRequest.getDepartment_code());
		edit.setEntry_date(editRequest.getEntry_date());
		edit.setProfile_image(editRequest.getProfile_image());

		editRepository.save(edit);
	}
}
