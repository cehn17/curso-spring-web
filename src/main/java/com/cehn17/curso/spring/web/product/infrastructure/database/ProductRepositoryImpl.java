package com.cehn17.curso.spring.web.product.infrastructure.database;

import com.cehn17.curso.spring.web.product.domain.entity.Product;
import com.cehn17.curso.spring.web.product.domain.port.ProductRepository;
import com.cehn17.curso.spring.web.product.infrastructure.database.entity.ProductEntity;
import com.cehn17.curso.spring.web.product.infrastructure.database.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final List<ProductEntity> products = new ArrayList<>();

    private final ProductEntityMapper productEntityMapper;


    @Override
    public void upsert(Product product) {
        ProductEntity productEntity = productEntityMapper.mapToProductEntity(product);
        this.products.removeIf(p -> p.getId().equals(productEntity.getId()));
        this.products.add(productEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(productEntityMapper::mapToProduct);
    }

    @Override
    public List<Product> findAll() {

        return this.products.stream().map(productEntityMapper::mapToProduct).toList();
    }

    @Override
    public void deleteById(Long id) {
        this.products.removeIf(product -> product.getId().equals(id));
    }
}
