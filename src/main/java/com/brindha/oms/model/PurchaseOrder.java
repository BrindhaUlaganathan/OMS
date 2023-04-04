package com.brindha.oms.model;


import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchaseorders")

public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name="order_id")
	private int orderId;
	@Column(name="customer_no")
	private int customerNo;
	@Column(name="order_date")
	private Date orderDate;
	
	@ManyToOne
	@JoinColumn(name="customer_no",insertable=false,nullable=false,updatable=false)	
	private Customer customer;

//	@OneToMany(mappedBy = "order_id")
//	private List<OrderLine> orderLine;
	
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [orderId=" + orderId + ", customerNo=" + customerNo + ", orderDate=" + orderDate + "]";
	}
	
	public PurchaseOrder() {

	}
	public PurchaseOrder(int customerNo,Date orderDate) {
		this.customerNo = customerNo;
		this.orderDate = orderDate;
	}

	public PurchaseOrder(int orderId, int customerNo, Date orderDate) {
		this.orderId = orderId;
		this.customerNo = customerNo;
		this.orderDate = orderDate;
	}

	public PurchaseOrder(int customerNo) {

		this.customerNo = customerNo;
		Date date = new Date();
		orderDate = date;
		
		
	}

}
