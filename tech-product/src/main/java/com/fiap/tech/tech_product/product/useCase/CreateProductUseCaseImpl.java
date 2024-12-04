package com.fiap.tech.tech_product.product.useCase;

import com.fiap.tech.tech_product.core.repository.ProductRepository;
import com.fiap.tech.tech_product.core.useCase.CreateProductUseCase;
import com.fiap.tech.tech_product.domain.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private ProductRepository productRepository;

    @Override
    public Product execute(Product product) {
        return productRepository.save(product);
    }

}
