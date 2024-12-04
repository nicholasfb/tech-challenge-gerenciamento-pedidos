package com.fiap.tech.tech_product.product.adapter;

import com.fiap.tech.tech_product.domain.product.Product;
import com.fiap.tech.tech_product.product.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductAdapter {

    ProductAdapter INSTANCE = Mappers.getMapper(ProductAdapter.class);

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Product toDomain(ProductDTO dto);

    ProductDTO fromDomain(Product product);

}