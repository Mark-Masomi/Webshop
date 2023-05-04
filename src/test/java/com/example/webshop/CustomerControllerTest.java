package com.example.webshop;


import com.example.webshop.Webshop.models.Customer;
import com.example.webshop.Webshop.repos.CustomerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerRepo mockRepo;

    @BeforeEach
    public void init() {
        Customer c1 = new Customer(1L, "Maac Johnsson", "239829");
        Customer c2 = new Customer(2L, "Jesper Schon", "918273");
        Customer c3 = new Customer(3L, "Dimitri Jakobsson", "273635");
        Customer c4 = new Customer(4L, "Jax Payne", "837263");

        when(mockRepo.findById(1L)).thenReturn(Optional.of(c1));
        when(mockRepo.findById(2L)).thenReturn(Optional.of(c2));
        when(mockRepo.findById(3L)).thenReturn(Optional.of(c3));
        when(mockRepo.findById(4L)).thenReturn(Optional.of(c4));
        when(mockRepo.findAll()).thenReturn(Arrays.asList(c1, c2, c3, c4));
    }

    @Test
    void getAllCustomers() throws Exception {
        this.mvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"_embedded\":{\"customerList\":[" +
                        "{\"id\":1,\"fullName\":\"Maac Johnsson\",\"ssn\":\"239829\"}," +
                        "{\"id\":2,\"fullName\":\"Jesper Schon\",\"ssn\":\"918273\"}," +
                        "{\"id\":3,\"fullName\":\"Dimitri Jakobsson\",\"ssn\":\"273635\"}," +
                        "{\"id\":4,\"fullName\":\"Jax Payne\",\"ssn\":\"837263\"}]}," +
                        "\"_links\":{\"self\":{\"href\":\"http://localhost/customers\"}}}"));
    }

    @Test
    void getCustomerById() throws Exception {
        this.mvc.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"fullName\":\"Maac Johnsson\",\"ssn\":\"239829\"," +
                        "\"_links\":{\"self\":{\"href\":\"http://localhost/customers/1\"}," +
                        "\"Customers\":{\"href\":\"http://localhost/customers\"}}}"));

    }



}
