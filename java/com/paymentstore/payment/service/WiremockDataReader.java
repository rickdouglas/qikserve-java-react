package com.paymentstore.payment.service;

import com.paymentstore.payments.model.Product;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class WiremockDataReader {

    private static final String WIREMOCK_BASE_URL = "http://localhost:8081";

    public static List<Product> readProductsFromWiremock() {
        String productsUrl = WIREMOCK_BASE_URL + "/products";
        RestTemplate restTemplate = new RestTemplate();
        Product[] productsArray = restTemplate.getForObject(productsUrl, Product[].class);
        return productsArray != null ? List.of(productsArray) : new ArrayList<>();
    }

}
