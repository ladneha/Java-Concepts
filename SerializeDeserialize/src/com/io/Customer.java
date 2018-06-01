package com.io;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Customer implements Serializable {

	private String customerId;
	private String customerName;
	private transient String customerPassword;
	private long customerPincode;
	private String customerCity;

	public Customer(String customerId, String customerName,
			String customerPassword, long customerPincode, String customerCity) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerPincode = customerPincode;
		this.customerCity = customerCity;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public long getCustomerPincode() {
		return customerPincode;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName="
				+ customerName + ", customerPassword=" + customerPassword
				+ ", customerPincode=" + customerPincode + ", customerCity="
				+ customerCity + "]";
	}

}
