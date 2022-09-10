package com.employee.edit.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザー情報 リクエストデータ
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class EditRequest implements Serializable {
	
	   /**
	   * ID
	   */

	@NotNull
	private String user_id;
	
	/**
	 * 名前
	 */
	@NotEmpty(message = "名前を入力してください")
	@Size(max = 20, message = "名前は20桁以内で入力してください")
	private String name;
	/**
	 * 名前カナ
	 */
	@NotEmpty(message = "名前をカナで入力してください")
	@Size(max = 50, message = "名前は50桁以内で入力してください")
	private String name_kana;
	/**
	 * パスワード
	 */
	@NotEmpty(message = "パスワードを入力してください")
	@Size(max = 100, message = "名前は100文字以内で入力してください")
	private String password;
	/**
	 * メール
	 */
	@NotEmpty(message = "メールアドレスを入力してください")
	@Size(max = 50, message = "名前は50文字以内で入力してください")
	private String upn;
	/**
	 * 誕生日
	 */
//	@NotEmpty(message = "生年月日を入力してください")
//	private Date birthday;
	/**
	 * 性別
	 */
	@NotEmpty(message = "性別を選択してください")
	private String gender;
	/**
	 *　役職
	 */
//	@NotEmpty(message = "役職を選択してください")
//	private String role_code;
	/**
	 * 出身地
	 */
	@Nullable
	private String prefecture_code;
	/**
	 * 部署
	 */
	@Nullable
	private String department_code;
	/**
	 * 入社日
	 */
//	@NotEmpty(message = "入社日を入力してください")
//	private Date entry_date;
	/**
	 * プロフィール画像
	 */
//	@Nullable
//	private String profile_image;
}