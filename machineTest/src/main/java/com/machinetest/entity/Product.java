package com.machinetest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameOfProduct;
	private String descriprtion;
	private double price;
	private int quantity;
	 @ManyToOne
	    @JoinColumn(name = "category_id")
	    private Category category;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameOfProduct() {
		return nameOfProduct;
	}
	public void setNameOfProduct(String nameOfProduct) {
		this.nameOfProduct = nameOfProduct;
	}
	public String getDescriprtion() {
		return descriprtion;
	}
	public void setDescriprtion(String descriprtion) {
		this.descriprtion = descriprtion;
	}
	public double getPrice() {
		return price;
	}
	 public Category getCategory() {
	        return category;
	    }
	 public void setCategory(Category category) {
	        this.category = category;
	    }
	@Override
	public String toString() {
		return "Product [id=" + id + ", nameOfProduct=" + nameOfProduct + ", descriprtion=" + descriprtion + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
	public Product(Long id, String nameOfProduct, String descriprtion, double price, int quantity) {
		super();
		this.id = id;
		this.nameOfProduct = nameOfProduct;
		this.descriprtion = descriprtion;
		this.price = price;
		this.quantity = quantity;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
