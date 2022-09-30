package com.moorabi.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moorabi.springdemo.dao.CustomerDAO;
import com.moorabi.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(long id) {
		Customer theCustomer= customerDAO.getCustomer(id);
		return theCustomer;
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer theCustomer) {
		customerDAO.deleteCustomer(theCustomer);
		
	}
	
	@Override
	@Transactional
	public List<Customer> getCustomersByName(String name) {
		
		return customerDAO.getCustomersByName(name);
	}
}
