package com.cehn17.curso.spring.web.product.infrastructure.api;

import com.cehn17.curso.spring.web.product.infrastructure.api.dto.CreateProductDto;
import com.cehn17.curso.spring.web.product.infrastructure.api.dto.ProductDto;
import com.cehn17.curso.spring.web.product.infrastructure.api.dto.UpdateProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductApi {

    public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(required = false) String pageSize);

    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id);

    public ResponseEntity<Void> saveProduct (@RequestBody CreateProductDto productDto);

    public ResponseEntity<Void> updateProduct (@RequestBody UpdateProductDto productDto);

    public ResponseEntity<Void> deleteProduct (@PathVariable Long id);

}
