package com.example.Repositories;

import com.example.Data.Price;
import com.example.Data.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VariantRepository extends JpaRepository<Variant,Long> {
    List<Variant> findByProductId(Long productId);
}
