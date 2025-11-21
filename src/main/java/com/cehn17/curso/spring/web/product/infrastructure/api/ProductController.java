package com.cehn17.curso.spring.web.product.infrastructure.api;

import com.cehn17.curso.spring.web.common.mediator.Mediator;
import com.cehn17.curso.spring.web.product.application.command.create.CreateProductRequest;
import com.cehn17.curso.spring.web.product.application.command.delete.DeleteProductRequest;
import com.cehn17.curso.spring.web.product.application.command.update.UpdateProductRequest;
import com.cehn17.curso.spring.web.product.application.query.getAll.GetAllProductRequest;
import com.cehn17.curso.spring.web.product.application.query.getAll.GetAllProductResponse;
import com.cehn17.curso.spring.web.product.application.query.getById.GetProductByIdRequest;
import com.cehn17.curso.spring.web.product.application.query.getById.GetProductByIdResponse;
import com.cehn17.curso.spring.web.product.infrastructure.api.dto.CreateProductDto;
import com.cehn17.curso.spring.web.product.infrastructure.api.dto.ProductDto;
import com.cehn17.curso.spring.web.product.infrastructure.api.dto.UpdateProductDto;
import com.cehn17.curso.spring.web.product.infrastructure.api.mapper.ProductMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Product", description = " Product API operations")
@RequiredArgsConstructor
@Slf4j
public class ProductController implements ProductApi {

    private final Mediator  mediator;

    private final ProductMapper productMapper;

    @Operation(summary = "Get all products", description = "Get all products")
    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(required = false) String pageSize){

        log.info("Getting all products");

        GetAllProductResponse response = mediator.dispatch(new GetAllProductRequest());

        List<ProductDto> productDtos = response.getProducts().stream().map(productMapper::mapToProductDto).toList();

        log.info("Found {} products", productDtos.size());

        return ResponseEntity.ok(productDtos);
    }

    @Operation(summary = "Get product by id", description = "Get product  by id")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {

        log.info("Getting product with id {}" ,id);

        GetProductByIdResponse response = mediator.dispatch(new GetProductByIdRequest(id));
        ProductDto productDto = productMapper.mapToProductDto(response.getProduct());

        log.info("Found product with id {}" ,id);

        return ResponseEntity.ok(productDto);
    }

    @Operation(summary = "Save product", description = "Save Product")
    @PostMapping("")
    public ResponseEntity<Void> saveProduct(@ModelAttribute @Valid CreateProductDto productDto){

        log.info("Saving product with id {}" ,productDto.getId());

        CreateProductRequest request = productMapper.mapToCreateProductRequest(productDto);
        mediator.dispatch(request);

        log.info("Saved product with id {}" ,productDto.getId());

        return ResponseEntity.created(URI.create("/api/v1/products/".concat(productDto.getId().toString()))).build();
    }

    @Operation(summary = "Update product", description = "Update Product")
    @PutMapping("")
    public ResponseEntity<Void> updateProduct(@RequestBody @Valid UpdateProductDto productDto){

        log.info("Updating product with id {}" ,productDto.getId());

        UpdateProductRequest request = productMapper.mapToUpdateProductRequest(productDto);
        mediator.dispatch(request);

        log.info("Updated product with id {}" ,productDto.getId());

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete product", description = "Delete Product")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct (@PathVariable Long id){

        mediator.dispatchAsync(new DeleteProductRequest(id));

        return ResponseEntity.accepted().build();
    }

}
