package com.employee.edit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
/**
 * ユーザー情報d Entity
 */
@Entity
@Embeddable
@Data
@Table(name = "employee")
public class Edit implements Serializable {
  /**
   * ID
   */
  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String user_id;
  /**
   * 名前
   */
  @Column(name = "name")
  private String name;
  /**
   * 名前カナ
   */
  @Column(name = "name_kana")
  private String name_kana;
  /**
   * パスワード
   */
  @Column(name = "password")
  private String password;
  /**
   * メール
   */
  @Column(name = "upn")
  private String upn;
  /**
   * 誕生日
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "birthday")
  private Date birthday;
  /**
   * 性別
   */
  @Column(name = "gender")
  private String gender;
  
  /**
   * 役職
   */
  @Column(name = "role_code")
  private String role_code;
  /**
   * 出身地
   */
  @Column(name = "prefecture_code")
  private String prefecture_code;
  /**
   * 部署
   */
  @Column(name = "department_code")
  private String department_code;
  /**
   * 入社日
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "entry_date")
  private Date entry_date;
  
  @Column(name = "profile_image")
  private String profile_image;
  
}