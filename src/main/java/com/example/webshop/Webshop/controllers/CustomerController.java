package com.example.webshop.Webshop.controllers;

import com.example.webshop.Webshop.models.Customer;
import com.example.webshop.Webshop.repos.CustomerRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

private final CustomerRepo customerRepo;

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @RequestMapping("/add")
    public String addCustomer(@RequestParam String fullName,@RequestParam String SSN ){
        customerRepo.save(new Customer(fullName,SSN));
        return "Customer "+fullName+" was added to the database";
    }

    @RequestMapping("/allCustomers")
    public List<Customer> allCustomers(){
        return customerRepo.findAll();
    }

}
