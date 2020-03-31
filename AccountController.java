package com.star.mortgage.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.star.mortgage.dto.AccountSummaryDto;
import com.star.mortgage.exception.CustomerException;
import com.star.mortgage.service.AccountService;

/**
 * 
 * @author janbee
 *
 */
@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	
	@GetMapping("/accountSummary/{customerId}")
	public ResponseEntity<List<AccountSummaryDto>> getAccountSummary(@PathVariable Long customerId) throws CustomerException{
		List<AccountSummaryDto> accSummaryList = accountService.accountSummary(customerId); 
		return new ResponseEntity<>(accSummaryList,HttpStatus.OK);
	}
}
