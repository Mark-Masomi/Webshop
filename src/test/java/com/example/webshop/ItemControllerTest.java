package com.example.webshop;


import com.example.webshop.Webshop.models.Item;
import com.example.webshop.Webshop.repos.ItemRepo;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;




@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ItemRepo mockRepo;

    @BeforeEach
    public void init() {
        Item i1 = new Item(1L, "Dining table", 800.0);
        Item i2 = new Item(2L, "Smart Phone", 3000.0);
        Item i3 = new Item(3L, "Couch", 8000.0);
        Item i4 = new Item(4L, "Computer desk", 1800.0);
        Item i5 = new Item(5L, "Hiphop cap", 1100.0);

        when(mockRepo.findById(1L)).thenReturn(Optional.of(i1));
        when(mockRepo.findById(2L)).thenReturn(Optional.of(i2));
        when(mockRepo.findById(3L)).thenReturn(Optional.of(i3));
        when(mockRepo.findById(4L)).thenReturn(Optional.of(i4));
        when(mockRepo.findById(5L)).thenReturn(Optional.of(i5));
        when(mockRepo.findAll()).thenReturn(Arrays.asList(i1, i2, i3,i4,i5));
    }


    @Test
    void getAllItems() throws Exception {
        this.mvc.perform(get("/items"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"_embedded\":{\"itemList\":[" +
                        "{\"id\":1,\"name\":\"Dining table\",\"price\":800.0}," +
                        "{\"id\":2,\"name\":\"Smart Phone\",\"price\":3000.0}," +
                        "{\"id\":3,\"name\":\"Couch\",\"price\":8000.0}," +
                        "{\"id\":4,\"name\":\"Computer desk\",\"price\":1800.0}," +
                        "{\"id\":5,\"name\":\"Hiphop cap\",\"price\":1100.0}]}," +
                        "\"_links\":{\"self\":{\"href\":\"http://localhost/items\"}}}"));
    }


    @Test
    void getItemById() throws Exception {
        this.mvc.perform(get("/items/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Dining table\",\"price\":800.0," +
                        "\"_links\":{\"self\":{\"href\":\"http://localhost/items/1\"}," +
                        "\"Items\":{\"href\":\"http://localhost/items\"}}}"));

    }

    @Test
    void addItem() throws Exception {
        this.mvc.perform(get("/items/add?name=TestItem&price=1500"))
                .andExpect(status().isOk())
                .andExpect(content().string("The new item TestItem was added to databese!"));
    }



    @Test
    void newItemByPost() throws Exception {
        this.mvc.perform(post("/purchases/newbypost/1/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("The purchase was added to database"));
    }






}
