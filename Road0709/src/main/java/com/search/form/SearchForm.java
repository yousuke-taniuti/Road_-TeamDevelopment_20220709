
package com.search.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

 @Data
 public class SearchForm  {
  
     private String userId;
  
     private String userName;
  
     private Integer deptCd;
     
     private String kengen;
     
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date startDate;
     
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date endDate;
     
     
  }
