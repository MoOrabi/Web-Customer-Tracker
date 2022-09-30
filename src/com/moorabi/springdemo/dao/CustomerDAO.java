package com.moorabi.springdemo.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.moorabi.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(long id);

	public void deleteCustomer(Customer theCustomer);

	public List<Customer> getCustomersByName(String name);
	
}
