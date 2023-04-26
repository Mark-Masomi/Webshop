package com.example.webshop;

import com.example.webshop.Webshop.models.Customer;
import com.example.webshop.Webshop.models.Item;
import com.example.webshop.Webshop.repos.CustomerRepo;
import com.example.webshop.Webshop.repos.ItemRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*add the following to your MySql workbench, and you are set to go.
------------------------------------------------------------------
create database Webshop;
CREATE USER 'webshop'@'localhost' identified with mysql_native_password BY '****';
GRANT ALL ON *.* TO 'webshop'@'localhost' with grant option;
------------------------------------------------------------------
*/
@SpringBootApplication
public class WebshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebshopApplication.class, args);
    }

/*
    @Bean
    public CommandLineRunner shopDatabase(CustomerRepo customerRepo, ItemRepo itemRepo){
        return (args) ->{
            Item i1=new Item("Dining table",800);
            Item i2=new Item("Smart Phone",3000);
            Item i3=new Item("Couch",8000);
            Item i4=new Item("Computer desk",1800);
            Item i5=new Item("Hiphop cap",1100);
            itemRepo.save(i1);
            itemRepo.save(i2);
            itemRepo.save(i3);
            itemRepo.save(i4);
            itemRepo.save(i5);
            Customer c1=new Customer("Maac Johnsson","239829");
            Customer c2=new Customer("Jesper schon","918273");
            Customer c3=new Customer("Dimitri Jakobsson","273635");
            Customer c4=new Customer("Jax Payne","837263");
            customerRepo.save(c1);
            customerRepo.save(c2);
            customerRepo.save(c3);
            customerRepo.save(c4);

        };
    }
*/


}
