package com.example.controllers;

import com.example.Data.Customer;
import com.example.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @PostMapping("/add")
    public Customer addcustomer(@RequestBody  Customer customer){

        return repository.save(customer);
    }
    @PostMapping("/add-multiple")
    public List<Customer> addMultipleCustomers(@RequestBody List<Customer> customers) {
        return repository.saveAll(customers);
    }
    @GetMapping
    public List<Customer> getall() {
     return   repository.findAll();
}
  @DeleteMapping("/{id}")
  public void delete(@PathVariable  Long id){
   repository.deleteById(id);
}



}


















