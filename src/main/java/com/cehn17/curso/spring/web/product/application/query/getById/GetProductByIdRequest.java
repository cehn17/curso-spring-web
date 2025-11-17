package com.cehn17.curso.spring.web.product.application.query.getById;

import com.cehn17.curso.spring.web.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProductByIdRequest implements Request<GetProductByIdResponse> {

    private Long id;
}
