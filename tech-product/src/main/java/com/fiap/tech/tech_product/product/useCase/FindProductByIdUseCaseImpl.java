package com.fiap.tech.tech_product.product.useCase;

import com.fiap.tech.tech_product.core.exception.ResourceNotFoundException;
import com.fiap.tech.tech_product.core.repository.ProductRepository;
import com.fiap.tech.tech_product.core.useCase.FindProductByIdUseCase;
import com.fiap.tech.tech_product.domain.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindProductByIdUseCaseImpl implements FindProductByIdUseCase {

    private final ProductRepository productRepository;

    @Override
    public Product execute(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
    }

}
