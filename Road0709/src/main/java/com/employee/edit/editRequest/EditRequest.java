package com.employee.edit.editRequest;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
//@EqualsAndHashCode(callSuper = false)
@Data
public class EditRequest {

	@Size(max = 8, message = "IDは８桁以内で入力してください")
	@NotEmpty(message = "   IDを入力してください")
	private String user_id;

	@NotEmpty(message = "名前を入力してください")
	private String name;

	@NotEmpty(message = "カタカナで入力してください")
	private String name_kana;

	@NotEmpty(message = "passwordを入力してください")
	private String password;

	@Email(message = "正しい形式で入力してください")
	@NotEmpty(message = "メールアドレスを入力してください")
	private String upn;

//		@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "生年月日を入力してください")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	@NotNull(message = "性別を入力してください")
	private Integer gender;

	@NotNull(message = "出身都道府県を入力してください")
	private Integer prefecture_code;

	@NotNull(message = "部署を入力してください")
	private Integer department_code;
	
	@NotNull(message = "入社日を入力してください")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entry_date;

	private String prefecture_name;

	private String department_name;

	private String role_code;
}
