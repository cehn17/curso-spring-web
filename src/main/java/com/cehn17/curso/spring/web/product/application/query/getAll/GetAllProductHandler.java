package com.cehn17.curso.spring.web.product.application.query.getAll;

import com.cehn17.curso.spring.web.common.mediator.RequestHandler;
import com.cehn17.curso.spring.web.product.application.query.getById.GetProductByIdRequest;
import com.cehn17.curso.spring.web.product.application.query.getById.GetProductByIdResponse;
import com.cehn17.curso.spring.web.product.domain.Product;
import com.cehn17.curso.spring.web.product.domain.ProductRepository;
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



        List<Product> products = productRepository.findAll();


        return new GetAllProductResponse(products);
    }

    @Override
    public Class<GetAllProductRequest> getRequestType() {
        return GetAllProductRequest.class;
    }
}
