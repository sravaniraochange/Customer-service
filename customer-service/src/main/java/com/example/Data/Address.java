package com.example.Data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    @ManyToOne
    private Customer customer;
}
