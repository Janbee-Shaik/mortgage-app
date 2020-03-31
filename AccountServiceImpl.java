package com.star.mortgage.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.star.mortgage.dto.AccountSummaryDto;
import com.star.mortgage.entity.Account;
import com.star.mortgage.exception.CustomerException;
import com.star.mortgage.repository.AccountRepository;
import com.star.mortgage.utility.ErrorConstants;

/**
 * 
 * @author janbee
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<AccountSummaryDto> accountSummary(Long customerId) throws CustomerException {
		List<Account> accountList = accountRepository.findByCustomerId(customerId);
		if(accountList.isEmpty()) {
			throw new CustomerException(ErrorConstants.MORTGAGE_NOT_GENERATED);
		}
		List<AccountSummaryDto> accSummaryDto = accountList.stream().map(account -> {
			AccountSummaryDto dto = new AccountSummaryDto();
			BeanUtils.copyProperties(account, dto);
			return dto;
		}).collect(Collectors.toList());
		if (accSummaryDto.isEmpty())
			throw new CustomerException(ErrorConstants.MORTGAGE_NOT_GENERATED);
		else
			return accSummaryDto;
	}
		

}
