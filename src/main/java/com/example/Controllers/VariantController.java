package com.example.Controllers;


import com.example.Data.Variant;
import com.example.Repositories.ProductRepository;
import com.example.Repositories.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/variants")
    public class VariantController {

        @Autowired
        private VariantRepository variantRepo;

        @Autowired
        private ProductRepository productRepo;

        @PostMapping("/add")
        public ResponseEntity<Variant> addVariant(@RequestParam Long productId, @RequestBody Variant variant) {
            return productRepo.findById(productId).map(product -> {
                variant.setProduct(product);
                return ResponseEntity.ok(variantRepo.save(variant));
            }).orElse(ResponseEntity.notFound().build());
        }

        @PostMapping("/add-multiple")
        public List<Variant> addMultipleVariants(@RequestBody List<Variant> variants) {
            return variantRepo.saveAll(variants);
        }

        @GetMapping
        public List<Variant> getAllVariants() {
            return variantRepo.findAll();
        }

        @GetMapping("/product/{productId}")
        public List<Variant> getVariantsByProduct(@PathVariable Long productId) {
            return variantRepo.findByProductId(productId);
        }
    }


