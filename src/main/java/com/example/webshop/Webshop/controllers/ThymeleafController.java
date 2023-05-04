package com.example.webshop.Webshop.controllers;

import com.example.webshop.Webshop.models.Customer;
import com.example.webshop.Webshop.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ThymeleafController {

    @Autowired
    private CustomerRepo customerRepository;

    @GetMapping("/customersHTML")
    public String showCustomers(Model model) {
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customerList";
    }

}

