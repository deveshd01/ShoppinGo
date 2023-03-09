package com.pratiti.entity;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the retailer database table.
 * 
 */
@Entity
@NamedQuery(name="Retailer.findAll", query="SELECT r FROM Retailer r")
public class Retailer  {
	@Id
	private int id;

	private String email;

	private String name;

	private String password;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="retailer")
	private List<Product> products;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="adminId")
	private Admin admin;

	public Retailer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setRetailer(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setRetailer(null);

		return product;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}