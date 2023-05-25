package com.example.webshop.Webshop.repos;

import com.example.webshop.Webshop.models.Customer;
import com.example.webshop.Webshop.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepo extends JpaRepository<Purchase,Long> {
    List<Purchase> findByKund(Customer customer);
}
