package com.example.webshop.Webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    @Id @GeneratedValue
    private Long id;
    private Date dateOfPurchase;
    @ManyToOne @JoinColumn(name = "kund_id")
    private Customer kund;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "purchase_vara",
            joinColumns =@JoinColumn(name = "purchae_id"),
            inverseJoinColumns = @JoinColumn(name = "purchase_id"))



    private List<Item> itemsList;


    public Purchase(Date dateOfPurchase, Customer kund, List<Item> itemsList) {
        this.dateOfPurchase = dateOfPurchase;
        this.kund = kund;
        this.itemsList=itemsList;
    }
}
