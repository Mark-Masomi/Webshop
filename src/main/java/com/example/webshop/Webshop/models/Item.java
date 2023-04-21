package com.example.webshop.Webshop.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Item {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

}
