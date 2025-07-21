package com.example.Controllers;


import com.example.Data.Price;
import com.example.Repositories.PriceRepository;
import com.example.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceRepository priceRepo;

    @Autowired
    private ProductRepository productRepo;

    @PostMapping("/add")
    public ResponseEntity<Price> addPrice(@RequestParam Long productId, @RequestBody Price price) {
        return productRepo.findById(productId).map(product -> {
            price.setProduct(product);
            return ResponseEntity.ok(priceRepo.save(price));
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Price> getAllPrices() {
        return priceRepo.findAll();
    }

    @GetMapping("/product/{productId}")
    public List<Price> getPriceByProduct(@PathVariable Long productId) {
        return priceRepo.findByProductId(productId);
    }
}
