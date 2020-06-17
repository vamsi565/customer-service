package com.vami.dev.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vami.dev.work.entity.Customer;
@Repository
public abstract class CustomerRepository implements JpaRepository<Customer, String> {
	
}