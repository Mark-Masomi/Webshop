package com.example.webshop.Webshop.controllers;

import com.example.webshop.Webshop.models.Customer;
import com.example.webshop.Webshop.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/customers")
public class CustomerController {

private final CustomerRepo customerRepo;

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }



    @GetMapping("")
    CollectionModel<EntityModel<Customer>> all(){
        List<EntityModel<Customer>> customerList=customerRepo.findAll().stream()
                .map(item ->EntityModel.of(item,
                        linkTo(methodOn(CustomerController.class).one(item.getId())).withSelfRel(),
                        linkTo(methodOn(CustomerController.class).all()).withRel("Customers")))
                .collect(Collectors.toList());
        return CollectionModel.of(customerList,linkTo(methodOn(CustomerController.class)
                .all()).withSelfRel());
    }
    @GetMapping("/{id}")
    EntityModel<Customer> one(@PathVariable Long id) {

        Customer customer = customerRepo.findById(id).orElse(null);

        return EntityModel.of(customer,
                linkTo(methodOn(CustomerController.class).one(id)).withSelfRel(),
                linkTo(methodOn(CustomerController.class).all()).withRel("Customers"));
    }
    @RequestMapping("/add")
    public String addCustomer(@RequestParam String fullName,@RequestParam String SSN ){
        customerRepo.save(new Customer(fullName,SSN));
        return "Customer "+fullName+" was added to the database";
    }
    @PostMapping("/addbypost")
    public String addCustomerByPost(@RequestBody Customer customer){
        customerRepo.save(customer);
        return "Customer: "+customer.getFullName()+" was added to the database";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id ){
        String tempCusName;
        Customer tempcustomer=customerRepo.findById(id).get();
        tempCusName=tempcustomer.getFullName();
        customerRepo.deleteById(id);
        return "Customer "+tempCusName+" was successfully removed from database!";
    }

//"Customer "+customer.getFullName()+" was added to the database";


}
