package com.example.Data;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long   id;
    private  String name;

    private String phone;


    private LocalDate registeredDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Registration registration;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Payment> payments;


}
