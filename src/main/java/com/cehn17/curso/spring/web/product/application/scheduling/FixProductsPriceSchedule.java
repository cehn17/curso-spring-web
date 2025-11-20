package com.cehn17.curso.spring.web.product.application.scheduling;

import com.cehn17.curso.spring.web.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FixProductsPriceSchedule {

    private final ProductRepository productRepository;

    @Scheduled(fixedRate = 5000)
    public void fixProductsPrice() {
        log.info("Fixing products price");

        productRepository.findAll().forEach(product -> {
            product.setPrice(product.getPrice() * 1.1);
            productRepository.upsert(product);
        });
        log.info("Finished Fixed products price");

    }
}
