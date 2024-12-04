package com.fiap.tech.tech_product.product.useCase;

import com.fiap.tech.tech_product.core.repository.ProductRepository;
import com.fiap.tech.tech_product.core.useCase.FindProductUseCase;
import com.fiap.tech.tech_product.domain.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class FindProductUseCaseImpl implements FindProductUseCase {

    private ProductRepository productRepository;

    @Override
    public Set<Product> execute() {
        return productRepository.findAll();
    }

}
