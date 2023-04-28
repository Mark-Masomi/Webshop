package com.example.webshop.Webshop.controllers;

import com.example.webshop.Webshop.models.Customer;
import com.example.webshop.Webshop.models.Purchase;
import com.example.webshop.Webshop.repos.CustomerRepo;
import com.example.webshop.Webshop.repos.ItemRepo;
import com.example.webshop.Webshop.repos.PurchaseRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private final CustomerRepo customerRepo;
    private final ItemRepo itemRepo;
    private final PurchaseRepo purchaseRepo;

    public PurchaseController(CustomerRepo customerRepo, ItemRepo itemRepo, PurchaseRepo purchaseRepo) {
        this.customerRepo = customerRepo;
        this.itemRepo = itemRepo;
        this.purchaseRepo = purchaseRepo;
    }

    @GetMapping("")
    public List<Purchase> getAllPurchases(){
        return purchaseRepo.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable Long id){
        Optional<Purchase> purchaseId = purchaseRepo.findById(id);
        if (purchaseId.isPresent()) {
            return ResponseEntity.ok(purchaseId.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
    @PostMapping("/new/{customerid}/{itemid}")
    public String newPurchase(@PathVariable Long customerid,@PathVariable Long itemid ){

    }*/
}










