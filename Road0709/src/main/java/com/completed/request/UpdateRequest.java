package com.completed.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UpdateRequest extends EditCompletedRequest implements Serializable {
	
	@NotNull
	  private Long salaryNumber;
	
	@NotNull
	  private Long userId;

}
