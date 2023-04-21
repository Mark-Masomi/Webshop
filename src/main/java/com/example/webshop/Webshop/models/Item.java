package com.example.webshop.Webshop.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Item {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
