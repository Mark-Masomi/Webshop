package com.example.webshop.Webshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Customer {
    @GeneratedValue
    @Id
    private Long id;
    private String fullName;
    private String SSN;


    public Customer(String fullName, String SSN) {
        this.fullName = fullName;
        this.SSN = SSN;
    }
}
