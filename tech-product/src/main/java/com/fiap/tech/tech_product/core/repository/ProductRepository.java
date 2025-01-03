package com.fiap.tech.tech_product.core.repository;

import com.fiap.tech.tech_product.domain.product.Product;

import java.util.Optional;
import java.util.Set;

public interface ProductRepository {

    Optional<Product> findById(Long id);

    Product save(Product product);

    Product update(Product product);

    Set<Product> findAll();

}
