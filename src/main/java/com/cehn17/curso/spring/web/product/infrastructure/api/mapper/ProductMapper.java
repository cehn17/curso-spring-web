package com.cehn17.curso.spring.web.product.infrastructure.api.mapper;

import com.cehn17.curso.spring.web.product.application.command.create.CreateProductRequest;
import com.cehn17.curso.spring.web.product.application.command.update.UpdateProductRequest;
import com.cehn17.curso.spring.web.product.domain.entity.Product;
import com.cehn17.curso.spring.web.product.infrastructure.api.dto.CreateProductDto;
import com.cehn17.curso.spring.web.product.infrastructure.api.dto.ProductDto;
import com.cehn17.curso.spring.web.product.infrastructure.api.dto.UpdateProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {

    CreateProductRequest mapToCreateProductRequest(CreateProductDto createProductDto);

    UpdateProductRequest mapToUpdateProductRequest(UpdateProductDto updateProductDto);

    ProductDto mapToProduct(Product product);
}
