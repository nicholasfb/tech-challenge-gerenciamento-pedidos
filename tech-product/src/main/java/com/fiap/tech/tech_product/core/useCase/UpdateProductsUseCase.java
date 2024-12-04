package com.fiap.tech.tech_product.core.useCase;

import org.springframework.web.multipart.MultipartFile;

public interface UpdateProductsUseCase {

    void execute(MultipartFile file);

}
