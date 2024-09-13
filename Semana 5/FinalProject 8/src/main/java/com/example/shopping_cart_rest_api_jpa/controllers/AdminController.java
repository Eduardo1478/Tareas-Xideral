package com.example.shopping_cart_rest_api_jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shopping_cart_rest_api_jpa.models.Item;
import com.example.shopping_cart_rest_api_jpa.repository.ItemRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ItemRepository itemRepo;

    // Endpoint to load the admin page (admin.html)
    @GetMapping("/panel")
    public String adminPanel() {
        return "admin";  // This will load the 'admin.html' page
    }

    // Endpoint to create a new item
    @PostMapping("/addItem")
    public String addItem(@RequestBody Item item) {
        itemRepo.save(item);
        return "redirect:/admin/panel";  // Redirect back to the admin page after adding an item
    }
}
