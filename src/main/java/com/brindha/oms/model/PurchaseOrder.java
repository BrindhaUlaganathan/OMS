package com.brindha.oms.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "purchaseorder")

public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name="order_id")
	private int orderId;
	@Column(name="customer_no")
	private int customerNo;
	@Column(name="order_date")
	private LocalDate orderDate = LocalDate.now() ;
	
	@ManyToOne//(fetch= FetchType.LAZY)
	@JoinColumn(name="customer_no",insertable=false,nullable=false,updatable=false)
	private Customer customer;

	@OneToMany(mappedBy = "purchaseorder",cascade= CascadeType.ALL,orphanRemoval = true)
	private List<OrderLine> orderLine =new ArrayList<>();
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [orderId=" + orderId + ", customerNo=" + customerNo + ", orderDate=" + orderDate + "]";
	}
	
	public PurchaseOrder() {

	}
	public PurchaseOrder(int customerNo, LocalDate orderDate) {
		this.customerNo = customerNo;
		this.orderDate = orderDate;
	}

	public PurchaseOrder(int orderId, int customerNo, LocalDate orderDate) {
		this.orderId = orderId;
		this.customerNo = customerNo;
		this.orderDate = orderDate;
	}

	public PurchaseOrder(int customerNo) {

		this.customerNo = customerNo;
		
	}

	public PurchaseOrder(int orderId, int customerNo, LocalDate orderDate, Customer customer, List<OrderLine> orderLine) {
		this.orderId = orderId;
		this.customerNo = customerNo;
		this.orderDate = orderDate;
		this.customer = customer;
		this.orderLine = orderLine;
	}
}
