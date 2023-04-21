package com.example.webshop.Webshop.controllers;

import com.example.webshop.Webshop.models.Customer;
import com.example.webshop.Webshop.repos.CustomerRepo;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id ){
        String tempCusName;
        Customer tempcustomer=customerRepo.findById(id).get();
        tempCusName=tempcustomer.getFullName();
        customerRepo.deleteById(id);
        return "Customer "+tempCusName+" was successfully removed from database !";
    }

}
