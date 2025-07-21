package com.example.Controllers;

import com.example.Data.Product;
import com.example.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository repo;

    @PostMapping("/add")
    public Product add(@RequestBody Product product){
        return repo.save(product);

    }

    @PostMapping("/add-multiple")
    public List<Product> addmultipleprods(@RequestBody List<Product> product){

        return repo.saveAll(product);
    }

    @GetMapping
    public List<Product> getall(){
        return repo.findAll();
    }
}
