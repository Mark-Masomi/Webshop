package com.example.webshop.Webshop.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Purchase {
    @Id @GeneratedValue
    private Long id;
    private Date dateOfPurchase;
    @ManyToOne @JoinColumn
    private Customer kund;
    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    private List<Item> purchaseItems;

}
