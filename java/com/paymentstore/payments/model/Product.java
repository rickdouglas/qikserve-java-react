package com.paymentstore.payments.model;

import java.util.List;

public class Product {
	
	private String id;
    private String name;
    private int price;
    private List<PromotionRule> promotions;

    public Product() {
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public List<PromotionRule> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<PromotionRule> promotions) {
        this.promotions = promotions;
    }
	
}
