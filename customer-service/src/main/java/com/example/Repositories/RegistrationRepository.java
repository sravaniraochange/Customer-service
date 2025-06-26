package com.example.Repositories;

import com.example.Data.Customer;
import com.example.Data.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration,Long>{


}
