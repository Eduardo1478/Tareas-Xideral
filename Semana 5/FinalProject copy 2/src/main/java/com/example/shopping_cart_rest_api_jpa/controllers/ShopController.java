package com.example.shopping_cart_rest_api_jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping_cart_rest_api_jpa.models.Item;
import com.example.shopping_cart_rest_api_jpa.repository.ItemRepository;

@RestController
@RequestMapping("/shop")

public class ShopController {

    @Autowired
    private ItemRepository repo;

    // Basic endpoint to check if the API is connected
    @GetMapping()
    public String index(){
        return "Shop Connected"; 
    }

    // Endpoint to get a list of all items
    @GetMapping("items")
    public List<Item> getItems(){
        return repo.findAll(); 
    }

    // Endpoint to save a single item to the database
    @PostMapping("save")
    public String save(@RequestBody Item item){ // Maps the request body to an Item object
        System.out.println("New item: " + item);
        repo.save(item); 
        return "saved item";
    } 

    // Endpoint to save a list of items to the database
    @PostMapping("/saveList")
    public String saveList(@RequestBody List<Item> items) {
        repo.saveAll(items); 
        return "saved list"; 
    }

    // Endpoint to update an item in the database by id
    @PutMapping("edit/{id}")
    public String update(@PathVariable long id, @RequestBody Item item){
        // Finds the item by id, throws an exception if not found
        Item updateItem = repo.findById(id).get(); 
        // Updates the item's fields with the values from the request
        updateItem.setName(item.getName());
        updateItem.setPrice(item.getPrice());
        updateItem.setExpiryDate(item.getExpiryDate());
        updateItem.setSection(item.getSection());
        updateItem.setWeight(item.getWeight());
        // Saves the updated item back to the repository
        repo.save(updateItem);
        return "edited"; 
    }

    // Endpoint to delete an item by id
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable long id, @RequestBody Item item){
        // Finds the item by id, throws an exception if not found
        Item deleteItem = repo.findById(id).get();
        // Deletes the item from the repository
        repo.delete(deleteItem);
        return "deleted"; 
    }
}
