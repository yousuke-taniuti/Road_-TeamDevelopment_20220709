package com.search.form;

import java.util.Date;

import lombok.Data;

 @Data
 public class SearchForm2  {
  
     private String userId;
  
     private String userName;
 
     private String name_kana;
  
     private Date birthday;
  
     private Integer gender;
 
     private Integer prefecture_code;
     
     private String prefecture_name;
  
     private Integer deptCd;
     
     private String department_name;
     
     private Date entry_date;

     private String role_code;
 
  }
