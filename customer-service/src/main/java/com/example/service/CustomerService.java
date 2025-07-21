package com.example.service;

import com.example.Data.Customer;
import com.example.Data.CustomerRequestDTO;

import java.util.List;

public interface CustomerService
{
    Customer addCustomer(CustomerRequestDTO customerDto);
    List<Customer> addMultipleCustomers(List<CustomerRequestDTO> customers);
    List<Customer> getAll();
    void delete(Long id);
}
