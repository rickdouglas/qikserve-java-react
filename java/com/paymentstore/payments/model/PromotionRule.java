package com.paymentstore.payments.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PromotionRule {
    private String id;
    private String type;
    @JsonProperty("required_qty")
    private int required_qty;
    @JsonProperty("free_qty")
    private int free_qty;
    private double price;
    private double amount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRequiredQty() {
		return required_qty;
	}
	public void setRequiredQty(int requiredQty) {
		this.required_qty = requiredQty;
	}
	public int getFreeQty() {
		return free_qty;
	}
	public void setFreeQty(int freeQty) {
		this.free_qty = freeQty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
    
    

}
