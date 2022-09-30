package com.moorabi.springdemo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moorabi.springdemo.entity.Customer;
import com.moorabi.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> theCustomers=customerService.getCustomers();
		theModel.addAttribute("customers",theCustomers);
		return "list-customers";
	}
	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "add-customer";
	}
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("customerId")long id,Model theModel) {
		Customer theCustomer=customerService.getCustomer(id);
		theModel.addAttribute("customer", theCustomer);
		return "update-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId")long id) {
		Customer theCustomer=customerService.getCustomer(id);
		customerService.deleteCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("theSearchName")String name,
								Model theModel) {
		List<Customer> theCustomers=customerService.getCustomersByName(name);
		theModel.addAttribute("customers",theCustomers);
		return "list-customers";
	}
}
