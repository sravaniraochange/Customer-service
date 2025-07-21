package com.example.Data;

import lombok.Data;

import java.util.List;
@Data
public class CustomerRequestDTO {
    private String name;
    private String phone;
    private List<Address> address;
}
