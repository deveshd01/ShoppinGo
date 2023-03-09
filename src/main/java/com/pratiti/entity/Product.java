package com.pratiti.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product  {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int availableUnits;

	private String brand;

	private String category;

	private String colour;

	private String name;

	private String pictures;

	private int price;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="product")
	private List<Order> orders;

	//bi-directional many-to-one association to Retailer
	@ManyToOne
	@JoinColumn(name="retailerId")
	private Retailer retailer;

	public Product() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAvailableUnits() {
		return this.availableUnits;
	}

	public void setAvailableUnits(int availableUnits) {
		this.availableUnits = availableUnits;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getColour() {
		return this.colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPictures() {
		return this.pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setProduct(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setProduct(null);

		return order;
	}

	public Retailer getRetailer() {
		return this.retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

}