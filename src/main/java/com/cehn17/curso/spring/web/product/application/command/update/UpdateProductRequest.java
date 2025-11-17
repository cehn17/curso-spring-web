package com.cehn17.curso.spring.web.product.application.command.update;

import com.cehn17.curso.spring.web.common.mediator.Request;
import lombok.Data;

@Data
public class UpdateProductRequest implements Request<Void> {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
}
