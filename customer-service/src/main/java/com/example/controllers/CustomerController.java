package com.example.controllers;

import com.example.Data.Customer;
import com.example.Data.CustomerRequestDTO;
import com.example.Repositories.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody CustomerRequestDTO dto) {
        return service.addCustomer(dto);
    }

    @PostMapping("/add-multiple")
    public List<Customer> addMultipleCustomers(@RequestBody List<CustomerRequestDTO> dtos) {
        return service.addMultipleCustomers(dtos);
    }

    @GetMapping
    public List<Customer> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


}


















