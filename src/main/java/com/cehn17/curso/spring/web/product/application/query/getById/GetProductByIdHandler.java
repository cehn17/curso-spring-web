package com.cehn17.curso.spring.web.product.application.query.getById;

import com.cehn17.curso.spring.web.common.mediator.RequestHandler;
import com.cehn17.curso.spring.web.product.domain.Product;
import com.cehn17.curso.spring.web.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetProductByIdHandler implements RequestHandler<GetProductByIdRequest, GetProductByIdResponse> {

    private final ProductRepository productRepository;

    @Override
    public GetProductByIdResponse handle(GetProductByIdRequest request) {

        log.info("Getting product with id {}", request.getId());

        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new IllegalArgumentException("Product not found"));

        log.info("Found product with id {}", request.getId());

        return new GetProductByIdResponse(product);
    }

    @Override
    public Class<GetProductByIdRequest> getRequestType() {
        return GetProductByIdRequest.class;
    }
}
