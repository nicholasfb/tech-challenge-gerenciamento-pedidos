package com.fiap.tech.tech_product.product.useCase;

import com.fiap.tech.tech_product.core.exception.UnprocessableEntityException;
import com.fiap.tech.tech_product.core.repository.ProductRepository;
import com.fiap.tech.tech_product.core.useCase.UpdateProductUseCase;
import com.fiap.tech.tech_product.domain.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private ProductRepository productRepository;

    @Override
    public Product execute(Long idProduct, Product product) {
        Product persistedProduct = productRepository.findById(idProduct).orElseThrow(
                () -> new UnprocessableEntityException(
                        "Erro ao atualizar um produto. Produto não encontrado"));

        product.setId(persistedProduct.getId());

        return productRepository.update(product);
    }

}
