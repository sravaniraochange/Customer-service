package com.example.Repositories;

import com.example.Data.Address;
import com.example.Data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long>{
    List<Address> findByCustomerId(Long customerId);

}
