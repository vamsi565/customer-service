package com.vami.dev.work.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vami.dev.work.dto.CustomerBaseResponse;
import com.vami.dev.work.dto.CustomerDTO;
import com.vami.dev.work.entity.Customer;
import com.vamsi.dev.work.interfaces.ICustomerService;

@RestController
public class CustomerServiceController {
	
	@Autowired
	private ICustomerService customerService;
	
	@ResponseBody
	public CustomerBaseResponse create(@RequestBody CustomerDTO customerDto){
		customerService.createCustomer(customerDto);
    	return 	new CustomerBaseResponse(HttpStatus.OK, true);
    	
    }
	
	@ResponseBody
	public Optional<Customer> fetch(@RequestBody String key){
		return customerService.fetchAllCustomer(key);    	
    }

}
