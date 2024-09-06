package com.example.shopping_cart_rest_api_jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping_cart_rest_api_jpa.models.Item;
import com.example.shopping_cart_rest_api_jpa.repository.Repository;

@RestController
public class Controller {

    @Autowired
    private Repository repo;

    @GetMapping()
    public String index(){
        return "Connected";
    }

    @GetMapping("items")
    public List<Item> getPerson(){
        return repo.findAll();
    }

    @PostMapping("save")
    public String save(@RequestBody Item item){
        System.out.println("New item: " + item);
        repo.save(item);
        return "saved";
    } 

    @PostMapping("/saveList")
        public String saveList(@RequestBody List<Item> items) {
        repo.saveAll(items); 
        return "saved list";
    }

    @PutMapping("edit/{id}")
    public String update(@PathVariable long id, @RequestBody Item item){
        Item updateItem = repo.findById(id).get();
        updateItem.setName(item.getName());
        updateItem.setPrice(item.getPrice());
        updateItem.setExpiryDate(item.getExpiryDate());
        updateItem.setSection(item.getSection());
        updateItem.setWeight(item.getWeight());
        repo.save(updateItem);
        return "edited";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable long id, @RequestBody Item item){
        Item deleteItem = repo.findById(id).get();
        repo.delete(deleteItem);
        return "deleted";
    }

    


}