package com.vami.dev.work.customerservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vami.dev.work.dto.CustomerDTO;
import com.vami.dev.work.entity.Customer;
import com.vami.dev.work.repository.CustomerRepository;
import com.vamsi.dev.work.assembler.CustomerAssembler;
import com.vamsi.dev.work.interfaces.ICustomerService;

@Service("customerService")
public class CustomerService implements ICustomerService{
	
	@Autowired
	public CustomerRepository customerRepository;
	
	@Override
	public void createCustomer(CustomerDTO customerDto)
	{
		Customer entity = new CustomerAssembler().fromDomainObject(customerDto);
		customerRepository.save(entity);
	}
	
	@Override
	public Optional<Customer> fetchAllCustomer(String key)
	{
		return customerRepository.findById(key);
	}

}
