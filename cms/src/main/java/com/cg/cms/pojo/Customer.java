package com.cg.cms.pojo;

public class Customer {

	// @Id
	// private ObjectId _id;
	private int customerId;
	private String customerName;
	private long contactNumber;

	
	public Customer() {
		
	}


	public Customer(int customerId, String customerName, long contactNumber) {
		
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
	}
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}



}
