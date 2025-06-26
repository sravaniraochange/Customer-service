package com.example.Repositories;

import com.example.Data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer,Long>{


}
