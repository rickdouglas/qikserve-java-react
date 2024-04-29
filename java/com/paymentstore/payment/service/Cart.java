package com.paymentstore.payment.service;

import com.paymentstore.payments.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();
    private int totalPrice = 0;
    private final Promotion promotion = new Promotion();

    public void addItem(String productId) throws IOException {
        List<Product> newProducts = WiremockDataReader.readProductsFromWiremock();
		if (newProducts != null) {
		    this.products.addAll(newProducts);
		    for (Product newProduct : newProducts) {
		        this.totalPrice += newProduct.getPrice();
		    }
		    promotion.applyPromotion(this, newProducts); 
		} else {
		    System.out.println("Produtos não encontrados.");
		}
    }

    public void removeItem(String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                this.products.remove(product);
                this.totalPrice -= product.getPrice();
                break;
            }
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getTotalPrice() {
        return totalPrice /100;
    }
}
