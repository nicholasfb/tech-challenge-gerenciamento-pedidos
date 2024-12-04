package com.fiap.tech.tech_product.core.useCase;

import com.fiap.tech.tech_product.domain.product.Product;

import java.util.Set;

public interface FindProductUseCase {

    Set<Product> execute();

}
