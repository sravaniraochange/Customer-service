package com.example.service;


import com.example.Data.Customer;
import com.example.Data.CustomerRequestDTO;
import com.example.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
    public class CustomerServiceImpl implements CustomerService {

        @Autowired
        private CustomerRepository repo;

        @Override
        public Customer addCustomer(CustomerRequestDTO dto) {
            Customer customer = new Customer();
            customer.setName(dto.getName());
            customer.setPhone(dto.getPhone());
            customer.setAddress(dto.getAddress());
            customer.setRegisteredDate(LocalDate.now());
            return repo.save(customer);
        }

        @Override
        public List<Customer> addMultipleCustomers(List<CustomerRequestDTO> customers) {
            return customers.stream()
                    .map(this::addCustomer)
                    .collect(Collectors.toList());
        }

        @Override
        public List<Customer> getAll() {
            return repo.findAll();
        }

        @Override
        public void delete(Long id) {
            repo.deleteById(id);
        }
}
