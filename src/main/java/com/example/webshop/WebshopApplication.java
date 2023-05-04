package com.example.webshop;

import com.example.webshop.Webshop.models.Customer;
import com.example.webshop.Webshop.models.Item;
import com.example.webshop.Webshop.models.Purchase;
import com.example.webshop.Webshop.repos.CustomerRepo;
import com.example.webshop.Webshop.repos.ItemRepo;
import com.example.webshop.Webshop.repos.PurchaseRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

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
    public CommandLineRunner shopDatabase(CustomerRepo customerRepo, ItemRepo itemRepo, PurchaseRepo purchaseRepo){
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
            List<Item> c1IL= Arrays.asList(i1,i5);
            Customer c2=new Customer("Jesper schon","918273");
            List<Item> c2IL= Arrays.asList(i2,i3);
            Customer c3=new Customer("Dimitri Jakobsson","273635");
            List<Item> c3IL= Arrays.asList(i3,i5);
            Customer c4=new Customer("Jax Payne","837263");
            List<Item> c4IL= Arrays.asList(i1,i4,i5);
            customerRepo.save(c1);
            customerRepo.save(c2);
            customerRepo.save(c3);
            customerRepo.save(c4);
            java.sql.Date currentDate=new Date(System.currentTimeMillis());
            Purchase purchase1=new Purchase(currentDate,c1,c1IL);
            Purchase purchase2=new Purchase(currentDate,c2,c2IL);
            Purchase purchase3=new Purchase(currentDate,c3,c3IL);
            Purchase purchase4=new Purchase(currentDate,c4,c4IL);
            purchaseRepo.save(purchase1);
            purchaseRepo.save(purchase2);
            purchaseRepo.save(purchase3);
            purchaseRepo.save(purchase4);

        };


    }

 */




*/

}
