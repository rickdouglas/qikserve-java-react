package com.paymentstore.payments;

import com.paymentstore.payment.service.Cart;
import com.paymentstore.payment.service.Promotion;

import java.io.IOException;

public class PaymentsApplication {

    public static void main(String[] args) throws IOException {
        Cart cart = new Cart();

        cart.addItem("PWWe3w1SDU");
		cart.addItem("Dwt5F7KAhi"); 
		cart.addItem("C8GDyLrHJb"); 

        System.out.println("Total before promotion: $" + cart.getTotalPrice());

                Promotion promotion = new Promotion();
        promotion.applyPromotion(cart, cart.getProducts());

        promotion.displaySavings();

                System.out.println("Total total after promotion: $" + cart.getTotalPrice());
    }
}
