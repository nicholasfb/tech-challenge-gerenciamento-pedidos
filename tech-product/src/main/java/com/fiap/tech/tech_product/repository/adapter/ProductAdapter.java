package com.fiap.tech.tech_product.repository.adapter;

import com.fiap.tech.tech_product.domain.product.Product;
import com.fiap.tech.tech_product.repository.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductAdapter {

    ProductAdapter INSTANCE = Mappers.getMapper(ProductAdapter.class);

    Product fromEntity(ProductEntity entity);

    ProductEntity toEntity(Product domain);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ProductEntity update(@MappingTarget ProductEntity persistedProduct, Product product);

}