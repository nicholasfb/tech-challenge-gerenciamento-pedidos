package com.fiap.tech.tech_product.mock;

import com.fiap.tech.tech_product.domain.product.Product;

import java.time.LocalDateTime;

public class ProductMock {

    public static Product mock() {
        return new Product(
                1L, "Produto Exemplo", 42, 42.2,
                42.2, 42, 42.22, LocalDateTime.now(), LocalDateTime.now()
        );
    }

}
