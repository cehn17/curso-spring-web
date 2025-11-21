package com.cehn17.curso.spring.web.product.application.query.getAll;

import com.cehn17.curso.spring.web.common.mediator.RequestHandler;
import com.cehn17.curso.spring.web.product.domain.entity.Product;
import com.cehn17.curso.spring.web.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetAllProductHandler implements RequestHandler<GetAllProductRequest, GetAllProductResponse> {

    private final ProductRepository productRepository;

    @Override
    public GetAllProductResponse handle(GetAllProductRequest request) {

        log.info("Getting all products");

        List<Product> products = productRepository.findAll();

        log.info("Products found: {}", products);

        return new GetAllProductResponse(products);
    }

    @Override
    public Class<GetAllProductRequest> getRequestType() {
        return GetAllProductRequest.class;
    }
}
