package com.example.webshop.Webshop.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Purchase {
    @Id @GeneratedValue
    private Long id;
    private Date dateOfPurchase;
    @ManyToOne @JoinColumn(name = "kund_id")
    private Customer kund;
    @ManyToMany
    @JoinTable(
            name = "purchase_vara",
            joinColumns =@JoinColumn(name = "purchae_id"),
            inverseJoinColumns = @JoinColumn(name = "purchase_id"))
    private List<Item> purchaseItems;



}
