package com.cehn17.curso.spring.web.product.infrastructure.api.mapper;

import com.cehn17.curso.spring.web.product.application.command.create.CreateProductRequest;
import com.cehn17.curso.spring.web.product.application.command.update.UpdateProductRequest;
import com.cehn17.curso.spring.web.product.domain.entity.Product;
import com.cehn17.curso.spring.web.product.infrastructure.api.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {

    CreateProductRequest mapToCreateProductRequest(ProductDto productDto);

    UpdateProductRequest mapToUpdateProductRequest(ProductDto productDto);

    ProductDto mapToProduct(Product product);
}
