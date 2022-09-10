package com.employee.edit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.employee.edit.entity.Edit;
import com.employee.edit.request.EditRequest;
import com.employee.edit.service.EditService;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー情報 Controller
 */
@RequestMapping
@RequiredArgsConstructor
@Controller
public class EditController {
	/**
	 * ユーザー情報 Service
	 */
	@Autowired
	private EditService editService;

	@SuppressWarnings("unused")
	@GetMapping(value = "/edit1")
	public String index(Model model) {
		EditRequest editRequest = new EditRequest();
		return "html/edit";
	}

//	（ログイン画面できたら）ログイン中のユーザーIDを取x得
//	@GetMapping("/")
//	public String displayList(@AuthenticationPrincipal User user, Model model) {
//		user.getUser_id();
//		List<Edit> editList = editService.searchAll();
//		model.addAttribute("editList", editList);
//		return "html/edit";
//	}
//
	/**
	 * ユーザー編集画面を表示
	 * 
	 * @param id    表示するユーザーID
	 * @param model Model
	 * @return ユーザー編集画面
	 */
	@GetMapping(value = "/")
	public String displayEdit(EditRequest editRequest, Model model) {
		Edit edit = editService.findById(editRequest.getUser_id());
		EditRequest editRequest1 = new EditRequest();
		editRequest1.setUser_id(edit.getUser_id());
		editRequest1.setName(edit.getName());
		editRequest1.setName_kana(edit.getName_kana());
		editRequest1.setPassword(edit.getPassword());
		editRequest1.setUpn(edit.getUpn());
		editRequest1.setBirthday(edit.getBirthday());
		editRequest1.setRole_code(edit.getRole_code());
		editRequest1.setPrefecture_code(edit.getPrefecture_code());
		editRequest1.setDepartment_code(edit.getDepartment_code());
		editRequest1.setEntry_date(edit.getEntry_date());
		editRequest1.setProfile_image(edit.getProfile_image());
//		List<Edit> editList = editService.findAll();
		model.addAttribute("editRequest", editRequest1);
		return "html/edit";
	}

	/**
	 * ユーザー更新
	 * 
	 * @param userRequest リクエストデータ
	 * @param model       Model
	 * @return ユーザー情報詳細画面
	 */
	  @RequestMapping("/")
	  public String update(@Valid EditRequest editRequest, BindingResult bindingResult) {
		  
	    if (bindingResult.hasErrors()) {
	    
	      return "html/edit";
	    }
	    
	    // ユーザー情報の更新
	    
	    return "redirect:/editcomplete";
	  }
	  
	  //ぷろふぃ＾る画像のアップロード
	  @ResponseBody  
	   @PostMapping(value = "upload" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    public Object upload(@RequestPart("file") MultipartFile filePart) throws IOException {  
	        File file = File.createTempFile(UUID.randomUUID().toString(), filePart.getOriginalFilename());   
	        filePart.transferTo(file.toPath());
	        byte[] bytes = Files.readAllBytes(file.toPath()); //ファイルの読み込み

	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.setContentType(MediaType.parseMediaType(Files.probeContentType(file.toPath())));  
	        httpHeaders.setContentLength(bytes.length);

	        return new HttpEntity<>(bytes, httpHeaders); //レスポンス
	    }
	  
	  
}