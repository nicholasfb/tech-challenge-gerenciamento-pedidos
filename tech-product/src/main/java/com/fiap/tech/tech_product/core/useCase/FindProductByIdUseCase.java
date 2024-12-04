package com.fiap.tech.tech_product.core.useCase;

import com.fiap.tech.tech_product.domain.product.Product;

public interface FindProductByIdUseCase {

    Product execute(Long id);

}
