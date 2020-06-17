package com.vamsi.dev.work.interfaces;

import java.util.Optional;

import com.vami.dev.work.dto.CustomerDTO;
import com.vami.dev.work.entity.Customer;

public interface ICustomerService {

	Optional<Customer> fetchAllCustomer(String key);

	void createCustomer(CustomerDTO customerDto);

}
