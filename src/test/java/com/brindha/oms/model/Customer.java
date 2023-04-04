package com.brindha.oms.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_no")
	private int customerNo;
	@Column(name="name")
	private String name;
	@Column(name="mobile")
	private String mobile;

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public String getName() {

		return name;
	}
	public void setName(String name) {

		this.name = name;
	}
	public String getMobile() {

		return mobile;
	}
	public void setMobile(String mobile) {

		this.mobile = mobile;
	}
	

	public Customer(String name, String mobile) {
		this.name = name;
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Customer [customer_no=" + customerNo + ", name=" + name + ", mobile=" + mobile + "]";
	}


}