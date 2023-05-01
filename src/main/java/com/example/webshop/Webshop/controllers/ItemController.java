package com.example.webshop.Webshop.controllers;

import com.example.webshop.Webshop.models.Item;
import com.example.webshop.Webshop.repos.ItemRepo;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemRepo itemRepo;

    public ItemController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @RequestMapping("")
    CollectionModel<EntityModel<Item>> all(){
        List<EntityModel<Item>> itemsList=itemRepo.findAll().stream()
                .map(item ->EntityModel.of(item,
                        linkTo(methodOn(ItemController.class).one(item.getId())).withSelfRel(),
                        linkTo(methodOn(ItemController.class).all()).withRel("Items")))
                .collect(Collectors.toList());
        return CollectionModel.of(itemsList,linkTo(methodOn(ItemController.class)
                .all()).withSelfRel());
    }

    @GetMapping("/{id}")
    EntityModel<Item> one(@PathVariable Long id) {

        Item item = itemRepo.findById(id).orElse(null);

        return EntityModel.of(item, //
                linkTo(methodOn(ItemController.class).one(id)).withSelfRel(),
                linkTo(methodOn(ItemController.class).all()).withRel("Items"));
    }
    @RequestMapping("/add")
    public String addItem(@RequestParam String name,@RequestParam Long price){
        Item tempItem=new Item(name,price);
        itemRepo.save(tempItem);
        return "The new item "+tempItem.getName()+" was added to databese!";
    }
    @PostMapping("/addbypost")
    public String addItemByPost(@RequestBody Item item ){
        itemRepo.save(item);
        return "The new item: "+item.getName()+" was added to the database!";
    }
    @RequestMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id){
        Item item=itemRepo.findById(id).get();
        itemRepo.deleteById(id);
        return "The item named: "+item.getName()+" were removed";
    }



}

