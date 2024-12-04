package com.fiap.tech.tech_product.core.useCase;

import com.fiap.tech.tech_product.domain.product.Product;

public interface UpdateProductUseCase {

    Product execute(Long idProduct, Product product);

}
