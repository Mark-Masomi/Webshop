package com.example.webshop;


import com.example.webshop.Webshop.models.Customer;
import com.example.webshop.Webshop.models.Item;
import com.example.webshop.Webshop.models.Purchase;

import com.example.webshop.Webshop.repos.CustomerRepo;
import com.example.webshop.Webshop.repos.ItemRepo;
import com.example.webshop.Webshop.repos.PurchaseRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.sql.Date;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PurchasesControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerRepo customerRepo;

    @MockBean
    private ItemRepo itemRepo;

    @MockBean
    private PurchaseRepo mockRepo;

    @BeforeEach
    public void init() {
        Item i1 = new Item("Dining table", 800.0);
        Item i2 = new Item("Smart Phone", 3000.0);
        Item i3 = new Item("Couch", 8000.0);
        Item i4 = new Item("Computer desk", 1800.0);
        Item i5 = new Item("Hiphop cap", 1100.0);

        when(itemRepo.save(i1)).thenReturn(new Item(1L, "Dining table", 800.0));
        when(itemRepo.save(i2)).thenReturn(new Item(2L, "Smart Phone", 3000.0));
        when(itemRepo.save(i3)).thenReturn(new Item(3L, "Couch", 8000.0));
        when(itemRepo.save(i4)).thenReturn(new Item(4L, "Computer desk", 1800.0));
        when(itemRepo.save(i5)).thenReturn(new Item(5L, "Hiphop cap", 1100.0));

        Customer c1 = new Customer("Maac Johnsson", "239829");
        Customer c2 = new Customer("Jesper Schon", "918273");
        Customer c3 = new Customer("Dimitri Jakobsson", "273635");
        Customer c4 = new Customer("Jax Payne", "837263");

        when(customerRepo.save(c1)).thenReturn(new Customer(1L, "Maac Johnsson", "239829"));
        when(customerRepo.save(c2)).thenReturn(new Customer(2L, "Jesper Schon", "918273"));
        when(customerRepo.save(c3)).thenReturn(new Customer(3L, "Dimitri Jakobsson", "273635"));
        when(customerRepo.save(c4)).thenReturn(new Customer(4L, "Jax Payne", "837263"));

        List<Item> c1IL = Arrays.asList(new Item(1L, "Dining table", 800.0), new Item(5L, "Hiphop cap", 1100.0));
        List<Item> c2IL = Arrays.asList(new Item(2L, "Smart Phone", 3000.0), new Item(3L, "Couch", 8000.0));
        List<Item> c3IL = Arrays.asList(new Item(3L, "Couch", 8000.0), new Item(5L, "Hiphop cap", 1100.0));
        List<Item> c4IL = Arrays.asList(new Item(1L, "Dining table", 800.0), new Item(4L, "Computer desk", 1800.0), new Item(5L, "Hiphop cap", 1100.0));

        Purchase purchase1 = new Purchase(1L, Date.valueOf("2023-05-03"), new Customer(1L, "Maac Johnsson", "239829"), c1IL);
        Purchase purchase2 = new Purchase(2L, Date.valueOf("2023-05-03"), new Customer(2L, "Jesper Schon", "918273"), c2IL);
        Purchase purchase3 = new Purchase(3L, Date.valueOf("2023-05-03"), new Customer(3L, "Dimitri Jakobsson", "273635"), c3IL);
        Purchase purchase4 = new Purchase(4L, Date.valueOf("2023-05-03"), new Customer(4L, "Jax Payne", "837263"), c4IL);

        when(mockRepo.findAll()).thenReturn(Arrays.asList(purchase1, purchase2, purchase3, purchase4));
    }





    @Test
    void GetAllPurchases() throws Exception {
        this.mvc.perform(get("/purchases"))
                .andExpect(status().isOk())
                .andExpect(content().json("["
                        + "{"
                        + "\"id\":1,"
                        + "\"dateOfPurchase\":\"2023-05-03\","
                        + "\"kund\":{\"id\":1,\"fullName\":\"Maac Johnsson\",\"ssn\":\"239829\"},"
                        + "\"itemsList\":["
                        + "{\"id\":1,\"name\":\"Dining table\",\"price\":800.0},"
                        + "{\"id\":5,\"name\":\"Hiphop cap\",\"price\":1100.0}"
                        + "]"
                        + "},"
                        + "{"
                        + "\"id\":2,"
                        + "\"dateOfPurchase\":\"2023-05-03\","
                        + "\"kund\":{\"id\":2,\"fullName\":\"Jesper Schon\",\"ssn\":\"918273\"},"
                        + "\"itemsList\":["
                        + "{\"id\":2,\"name\":\"Smart Phone\",\"price\":3000.0},"
                        + "{\"id\":3,\"name\":\"Couch\",\"price\":8000.0}"
                        + "]"
                        + "},"
                        + "{"
                        + "\"id\":3,"
                        + "\"dateOfPurchase\":\"2023-05-03\","
                        + "\"kund\":{\"id\":3,\"fullName\":\"Dimitri Jakobsson\",\"ssn\":\"273635\"},"
                        + "\"itemsList\":["
                        + "{\"id\":3,\"name\":\"Couch\",\"price\":8000.0},"
                        + "{\"id\":5,\"name\":\"Hiphop cap\",\"price\":1100.0}"
                        + "]"
                        + "},"
                        + "{"
                        + "\"id\":4,"
                        + "\"dateOfPurchase\":\"2023-05-03\","
                        + "\"kund\":{\"id\":4,\"fullName\":\"Jax Payne\",\"ssn\":\"837263\"},"
                        + "\"itemsList\":["
                        + "{\"id\":1,\"name\":\"Dining table\",\"price\":800.0},"
                        + "{\"id\":4,\"name\":\"Computer desk\",\"price\":1800.0},"
                        + "{\"id\":5,\"name\":\"Hiphop cap\",\"price\":1100.0}"
                        + "]"
                        + "}"
                        + "]"));
    }























}