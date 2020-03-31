package com.star.mortgage.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author janbee
 *
 */
@Setter
@Getter
public class AccountSummaryDto {
	
  private Long accountId;
  private String accountNumber;
  private Double balance;
  private String accountType;
  //private int StatusCode;
  //private String statusMessage;
}
