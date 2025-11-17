package com.cehn17.curso.spring.web.product.application.query.getById;

import com.cehn17.curso.spring.web.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GetProductByIdResponse {

    private Product product;
}

