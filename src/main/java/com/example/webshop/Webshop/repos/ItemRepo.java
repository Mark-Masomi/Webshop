package com.example.webshop.Webshop.repos;

import com.example.webshop.Webshop.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,Long> {
}
