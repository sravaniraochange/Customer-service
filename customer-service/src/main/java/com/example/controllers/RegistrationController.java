package com.example.controllers;

import com.example.Data.Registration;
import com.example.Repositories.CustomerRepository;
import com.example.Repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
@RestController
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private RegistrationRepository registrationRepo;
    @Autowired
    private CustomerRepository customerRepo;

    @PostMapping
    public ResponseEntity<Registration> register(@RequestParam Long customerId, @RequestParam String source) {
        return customerRepo.findById(customerId).map(customer -> {
            Registration reg = new Registration();
            reg.setCustomer(customer);
            reg.setSource(source);
            reg.setRegistrationDate(LocalDate.now());
            return ResponseEntity.ok(registrationRepo.save(reg));
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> getById(@PathVariable Long id) {
        return registrationRepo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}


