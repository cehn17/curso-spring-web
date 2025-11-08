package com.cehn17.curso.spring.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    public List<Product> products;

    public ProductController() {
        this.products = new ArrayList<>();
        this.products.add(Product.builder().id(1L).name("Product 1").description("Description 1").price(100.0). image("image").build());
        this.products.add(Product.builder().id(2L) .name("Product 2").description("Description 2").price(200.0).image("image2").build());
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getProduct(@RequestParam(required = false) String pageSize){
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> productoptional = products.stream()
                .filter( p -> p.getId().equals(id))
                .findFirst();
        return productoptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<Void> saveProduct (@RequestBody Product product){
        products.add(product);
        return ResponseEntity.created(URI.create("/api/v1/products/".concat(product.getId().toString()))).build();
    }

    @PutMapping("")
    public ResponseEntity<Product> updateProduct (@RequestBody Product product){
        Product productSelected = products.stream()
                .filter( p -> p.getId().equals(product.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productSelected. setName(product.getName());
        productSelected.setDescription(product.getDescription());
        productSelected.setPrice(product.getPrice());
        productSelected.setImage(product.getImage());
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct (@PathVariable Long id){
        products.removeIf(p -> p.getId().equals(id));

        return ResponseEntity.noContent().build();
    }

}
