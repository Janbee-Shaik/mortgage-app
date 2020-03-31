package com.star.mortgage.service;

import java.util.List;


import com.star.mortgage.dto.AccountSummaryDto;
import com.star.mortgage.exception.CustomerException;

public interface AccountService {

	/**
	 * 
	 * @param customerId
	 * @return
	 * @throws CustomerException 
	 */
	public List<AccountSummaryDto> accountSummary(Long customerId) throws CustomerException;
}
