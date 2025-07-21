package com.example.controllers;

import com.example.Data.Address;
import com.example.Repositories.AddressRepository;
import com.example.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private CustomerRepository customerRepo;

    // Add address for existing customer
    @PostMapping("/customer/{customerId}")
    public ResponseEntity<Address> addAddress(@PathVariable Long customerId, @RequestBody Address address) {
        return customerRepo.findById(customerId).map(customer -> {
            address.setCustomer(customer);
            return ResponseEntity.ok(addressRepo.save(address));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Get all addresses for a customer
    @GetMapping("/customer/{customerId}")
    public List<Address> getAddresses(@PathVariable Long customerId) {
        return addressRepo.findByCustomerId(customerId);
    }

    // Optional: Delete an address by ID
    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressRepo.deleteById(id);
    }
}

