package com.moorabi.springdemo.service;

import java.util.List;

import com.moorabi.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(long id);

	public void deleteCustomer(Customer theCustomer);

	public List<Customer> getCustomersByName(String name);
}
