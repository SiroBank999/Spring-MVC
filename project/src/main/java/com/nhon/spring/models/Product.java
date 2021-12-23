package com.nhon.spring.models;

import javax.validation.constraints.NotEmpty;

public class Product {
	private int id;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	private String code;
	//@NotEmpty(message = "Tên không được bỏ trống")
    private String name;
    private float price;
	
    
    public Product() {
		
	}
	
    public Product(int id, String code, String name, float price) {
		
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
	}
    
    public Product(String code, String name, float price) {
	
		this.code = code;
		this.name = name;
		this.price = price;
	}

    
}