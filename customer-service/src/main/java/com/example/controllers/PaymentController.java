package com.example.controllers;

import com.example.Data.Payment;
import com.example.Repositories.CustomerRepository;
import com.example.Repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepo;
    @Autowired
    private CustomerRepository customerRepo;

    @PostMapping
    public ResponseEntity<Payment> makePayment(@RequestParam Long customerId, @RequestBody Payment payment) {
        return customerRepo.findById(customerId).map(customer -> {
            payment.setCustomer(customer);
            payment.setPaymentDate(LocalDate.now());
            return ResponseEntity.ok(paymentRepo.save(payment));
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public List<Payment> getPaymentsForCustomer(@PathVariable Long customerId) {
        return paymentRepo.findByCustomerId(customerId);
    }
}