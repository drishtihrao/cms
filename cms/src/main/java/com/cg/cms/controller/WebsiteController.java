package com.cg.cms.controller;

import java.util.ArrayList;

import org.springframework.hateoas.Resources;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.cg.cms.pojo.Customer;

@Controller
public class WebsiteController {
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("home");
		return "home";
	}
	
	@RequestMapping("/error")
	public String error() {
		System.out.println("error");
		return "error";
	}

	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public String addNewCustomer(@RequestBody Customer customer) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> cust = restTemplate.getForEntity("http://localhost:8080/customer/add", Customer.class);
		return "addNewCustomer";
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String viewAllCustomers() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<?> cust = restTemplate.getForEntity("http://localhost:8080/customers", ArrayList.class);
		return "viewAllCustomers";
	}
	
	@RequestMapping(value = "/customers/{start}/{count}", method = RequestMethod.GET)
	public String viewAllCustomersBetween1(@PathVariable("start") int start, @PathVariable("count") int count) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Resources> cust = restTemplate.getForEntity("http://localhost:8080/customers/{start}/{count}", Resources.class);
		return "viewAllCustomersBetween";
	}
	
	@RequestMapping(value = "/customer/update", method = RequestMethod.PUT)
	public String updateCustomer(@PathVariable("start") int start, @PathVariable("count") int count) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Resources> cust = restTemplate.getForEntity("http://localhost:8080/customer/update", Resources.class, 2);
		return "updateCustomer";
	}
	

	
	@RequestMapping(value = "/customer/delete", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable("start") int start, @PathVariable("count") int count) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Resources> cust = restTemplate.getForEntity("http://localhost:8080/customer/delete", Resources.class, 2);
		return "deleteCustomer";
	}
	
	@RequestMapping(value = "/customers/{start}/{count}", method = RequestMethod.GET)
	public String getCustomerById(@PathVariable("start") int start, @PathVariable("count") int count) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Resources> cust = restTemplate.getForEntity("http://localhost:8080/customers/{start}/{count}", Resources.class, 2);
		return "getCustomerById";
	}
}
