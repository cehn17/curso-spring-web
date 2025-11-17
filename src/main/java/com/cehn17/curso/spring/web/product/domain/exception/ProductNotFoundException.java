package com.cehn17.curso.spring.web.product.domain.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("The product with id " + id + " was not found");
    }
}
