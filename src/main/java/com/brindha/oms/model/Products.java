package com.brindha.oms.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UPC")
	private int uPC;
	@Column(name = "prod_description")
	private String prodDescription;
	@Column(name = "unit_price")
	private float unitPrice;
	@Column(name = "unit")
	private String unit;
	@Column(name = "quantity")
	private int quantity;

	@OneToMany(mappedBy = "products",cascade= CascadeType.ALL,orphanRemoval = true)
	private List<OrderLine> orderLine =new ArrayList<>();


	public int getUPC() {
		return uPC;
	}

	public void setUPC(int uPC) {
		this.uPC = uPC;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Products [uPC=" + uPC + ", prodDescription=" + prodDescription + ", unitPrice=" + unitPrice + ", unit="
				+ unit + ", quantity=" + quantity + "]";
	}

	public Products() {
		super();
	}

	public Products(String prodDescription, float unitPrice) {
		super();

		this.prodDescription = prodDescription;
		this.unitPrice = unitPrice;
	}

	public Products(String prodDescription, float unitPrice, String unit) {
		super();

		this.prodDescription = prodDescription;
		this.unitPrice = unitPrice;
		this.unit = unit;
	}

	public Products(String prodDescription, float unitPrice, int quantity) {
		super();

		this.prodDescription = prodDescription;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public Products(String prodDescription, float unitPrice, String unit, int quantity) {
		this.prodDescription = prodDescription;
		this.unitPrice = unitPrice;
		this.unit = unit;
		this.quantity = quantity;
	}

	public Products(int uPC, String prodDescription, float unitPrice, String unit, int quantity) {
		this.uPC = uPC;
		this.prodDescription = prodDescription;
		this.unitPrice = unitPrice;
		this.unit = unit;
		this.quantity = quantity;
	}

	public Products(int uPC, String prodDescription, float unitPrice, String unit, int quantity, List<OrderLine> orderLine) {
		this.uPC = uPC;
		this.prodDescription = prodDescription;
		this.unitPrice = unitPrice;
		this.unit = unit;
		this.quantity = quantity;
		this.orderLine = orderLine;
	}
}