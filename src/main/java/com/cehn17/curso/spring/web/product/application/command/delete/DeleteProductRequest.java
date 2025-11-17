package com.cehn17.curso.spring.web.product.application.command.delete;

import com.cehn17.curso.spring.web.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteProductRequest implements Request<Void> {

    private Long id;
}
