package com.paymentstore.payment.service;

import java.util.List;

import com.paymentstore.payments.model.Product;
import com.paymentstore.payments.model.PromotionRule;

public class Promotion {
    private double savings = 0;

    public void applyPromotion(Cart cart, List<Product> products) {
        for (Product product : products) {
            List<PromotionRule> promotions = product.getPromotions();
            if (promotions != null) {
                for (PromotionRule promotion : promotions) {
                    switch (promotion.getType()) {
                        case "BUY_X_GET_Y_FREE":
                            applyBuyXGetYFreePromotion(cart, product, promotion);
                            break;
                        case "QTY_BASED_PRICE_OVERRIDE":
                            applyQtyBasedPriceOverridePromotion(cart, product, promotion);
                            break;
                        case "FLAT_PERCENT":
                            applyFlatPercentDiscountPromotion(cart, product, promotion);
                            break;
                    }
                }
            }
        }
    }
    private void applyBuyXGetYFreePromotion(Cart cart, Product product, PromotionRule promotion) {
        int requiredQty = promotion.getRequiredQty();
        int freeQty = promotion.getFreeQty();
        int totalQty = countProductQtyInCart(cart, product);

        if (totalQty >= requiredQty) {
            int applicableFreeQty = totalQty / requiredQty * freeQty;
            savings += applicableFreeQty * (product.getPrice() / 100.0);
        }
    }

    private void applyQtyBasedPriceOverridePromotion(Cart cart, Product product, PromotionRule promotion) {
        int requiredQty = promotion.getRequiredQty();
        double newPrice = promotion.getPrice();
        int totalQty = countProductQtyInCart(cart, product);

        if (totalQty >= requiredQty) {
            savings += ((product.getPrice() - newPrice) / 100.0) * totalQty;
        }
    }

    private void applyFlatPercentDiscountPromotion(Cart cart, Product product, PromotionRule promotion) {
        double discountPercent = promotion.getAmount() / 100.0;
        savings += discountPercent * product.getPrice() / 100.0 * countProductQtyInCart(cart, product);
    }

    private int countProductQtyInCart(Cart cart, Product product) {
        int count = 0;
        for (Product cartProduct : cart.getProducts()) {
            if (cartProduct.getId().equals(product.getId())) {
                count++;
            }
        }
        return count;
    }

    public void displaySavings() {
        System.out.printf("You saved: $%.2f%n", savings);
    }
}
