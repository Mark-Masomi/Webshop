package com.example.webshop.Webshop.repos;

import com.example.webshop.Webshop.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
