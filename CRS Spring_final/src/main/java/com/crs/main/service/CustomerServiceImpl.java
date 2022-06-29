package com.crs.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crs.main.model.Customers;
import com.crs.main.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customers> fetchAllCustomers() {
		return customerRepository.findAll();
	}
	
	public void saveCustomer(Customers customer) {
		customerRepository.save(customer);
	}
	
	public Customers findCustomerById(String email) {
		Customers customer = customerRepository.findById(email).orElse(null);
		return customer;
	}
	
	public void deleteCustomer(Customers customer) {
		customerRepository.delete(customer);
	}

	public Boolean validateCustomer(String customerEmail, String customerPassword) {
		
		if (customerRepository.findById(customerEmail).isPresent()) {
			Customers customer = customerRepository.findById(customerEmail).get();
			String dbPassword = customer.getCustomerPassword().toString();
			if (dbPassword.equals(customerPassword)) {
				return true;
			}
		}
		return false;
	}

}
