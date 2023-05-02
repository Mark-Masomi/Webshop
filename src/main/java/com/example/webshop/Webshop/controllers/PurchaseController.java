package com.example.webshop.Webshop.controllers;

import com.example.webshop.Webshop.models.Customer;
import com.example.webshop.Webshop.models.Item;
import com.example.webshop.Webshop.models.Purchase;
import com.example.webshop.Webshop.repos.CustomerRepo;
import com.example.webshop.Webshop.repos.ItemRepo;
import com.example.webshop.Webshop.repos.PurchaseRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import java.util.List;
import java.util.stream.Collectors;

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
    @RequestMapping("/{id}")
    public Purchase getPurchaseById(@PathVariable Long id){
        return purchaseRepo.findById(id).get();
    }
    @RequestMapping("/delete/{id}")
    public List<Purchase> deleteById(@PathVariable Long id){
        purchaseRepo.deleteById(id);
        return purchaseRepo.findAll();
    }


    @PostMapping("/newbypost/{customerid}/{itemid}")
    public String newPurchaseByPost(@PathVariable Long customerid,@PathVariable Long itemid ){
        Customer customer=customerRepo.findById(customerid).get();
        Item item=itemRepo.findById(itemid).get();
        Date currentDate=new Date(System.currentTimeMillis());
        List<Item> itemsList=new ArrayList<>();
        itemsList.add(item);
        Purchase purchase=new Purchase(currentDate,customer,itemsList);
        purchaseRepo.save(purchase);
        return "The purchase was added to database";
    }
    @RequestMapping("/newbyget/{customerid}/{itemid}")
    public String newPurchaseByget(@PathVariable Long customerid,@PathVariable Long itemid ){
        Customer customer=customerRepo.findById(customerid).get();
        Item item=itemRepo.findById(itemid).get();
        List<Item> itemsList=new ArrayList<>();
        itemsList.add(item);
        Date currentDate=new Date(System.currentTimeMillis());

        Purchase purchase=new Purchase(currentDate,customer,itemsList);
        purchaseRepo.save(purchase);
        return "The purchase was added to database";
    }
    @RequestMapping("/moreitems/{purchaseid}/{newitemsid}")
    public String addMoreItemsToPurchase(@PathVariable Long purchaseid,@PathVariable Long newitemsid){
        Purchase existingPurchase=purchaseRepo.findById(purchaseid).get();
        Item newitem=itemRepo.findById(newitemsid).get();
        List<Item> itemList=existingPurchase.getItemsList();
        itemList.add(newitem);
        existingPurchase.setItemsList(itemList);
        if (existingPurchase !=null){
        purchaseRepo.save(existingPurchase);
        }
        return "The "+newitem.getName()+" was added to the existing purchase";
    }
    @RequestMapping("/forcustomer/{customerid}")
    public List<Purchase> customerPurchases(@PathVariable Long customerid){
        Customer customer=customerRepo.findById(customerid).get();
        /*List<Purchase> purchases=purchaseRepo.findAll();
        List<Purchase> customerPurchases=purchases.stream().filter(purchase ->
                purchase.getKund().equals(customer)).collect(Collectors.toList());
        return customerPurchases;*/
        return purchaseRepo.findByKund(customer);

    }



    /*Date specificDate = Date.valueOf("2022-05-20");
        System.out.println("Specific date: " + specificDate);
    */
}
    //sökfram alla köp i databasen och filtrera efter vilken kund som gjort alla köpen










