package com.cehn17.curso.spring.web.product.application.query.getAll;

import com.cehn17.curso.spring.web.common.mediator.Request;
import com.cehn17.curso.spring.web.product.application.query.getById.GetProductByIdResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAllProductRequest implements Request<GetAllProductResponse> {

}
