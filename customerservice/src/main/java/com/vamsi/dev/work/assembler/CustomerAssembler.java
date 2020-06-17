package com.vamsi.dev.work.assembler;

import com.vami.dev.work.dto.CustomerDTO;
import com.vami.dev.work.entity.Customer;

public class CustomerAssembler {

	public Customer fromDomainObject(CustomerDTO customerDto) {
		Customer customer = null;
		if(customerDto != null)
		{
			customer.setMail(customerDto.getMail());
			customer.setMobileNumber(customerDto.getMobileNumber());
			customer.setName(customerDto.getName());
			customer.setAddress(customerDto.getAddress());
		}
		return customer;
	}
	
	public CustomerDTO toDomainObject(Customer customer){
		CustomerDTO dto = null;
		if(customer != null)
		{
			dto.setMobileNumber(customer.getMobileNumber());
			dto.setMail(customer.getMail());
			dto.setName(customer.getName());
			dto.setAddress(customer.getAddress());
		}
		return dto;
	}

}
