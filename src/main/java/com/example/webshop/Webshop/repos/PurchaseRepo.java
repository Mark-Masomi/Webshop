package com.example.webshop.Webshop.repos;

import com.example.webshop.Webshop.models.Item;
import com.example.webshop.Webshop.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepo extends JpaRepository<Purchase,Long> {
}
