package com.cehn17.curso.spring.web.product.domain.port;

import com.cehn17.curso.spring.web.product.domain.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void upsert(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);
}
