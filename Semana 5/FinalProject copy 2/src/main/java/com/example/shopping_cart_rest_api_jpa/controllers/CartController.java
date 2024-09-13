package com.example.shopping_cart_rest_api_jpa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping_cart_rest_api_jpa.models.Cart;
import com.example.shopping_cart_rest_api_jpa.models.CartItem;
import com.example.shopping_cart_rest_api_jpa.models.CartItemKey;
import com.example.shopping_cart_rest_api_jpa.models.Item;
import com.example.shopping_cart_rest_api_jpa.repository.CartItemRepository;
import com.example.shopping_cart_rest_api_jpa.repository.CartRepository;
import com.example.shopping_cart_rest_api_jpa.repository.ItemRepository;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private ItemRepository itemRepo;

    @Autowired
    private CartItemRepository cartItemRepo;

    // Basic endpoint to check if the API is connected
    @GetMapping()
    public String index() {
        return "Cart Connected";
    }

    @PostMapping("/createCart")
    public String createCart() {
        Cart cart = new Cart();
        cartRepo.save(cart);
        return "Cart created with ID: " + cart.getId();
    }

    @GetMapping("/view/{cartId}")
    public Cart viewCart(@PathVariable long cartId) {
        return cartRepo.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found with ID: " + cartId));
    }

    @PostMapping("/addItem/{cartId}/{itemId}")
    public String addItemToCart(@PathVariable long cartId, @PathVariable long itemId) {
        // Retrieve the cart and item, throw an exception if not found
        Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found with ID: " + cartId));
        Item item = itemRepo.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId));
    
        // Create a composite key
        CartItemKey cartItemKey = new CartItemKey();
        cartItemKey.setCartId(cartId);
        cartItemKey.setItemId(itemId);
    
        // Check if the item is already in the cart
        Optional<CartItem> cartItemOptional = cartItemRepo.findById(cartItemKey);
    
        CartItem cartItem;
        if (cartItemOptional.isPresent()) {
            // If item already exists in the cart, update quantity
            cartItem = cartItemOptional.get();
            cartItem.setQuantity(cartItem.getQuantity() + 1);  // Increase the quantity
        } else {
            // If item is not in the cart, create a new CartItem
            cartItem = new CartItem();
            cartItem.setCart(cart);   // Set the cart reference
            cartItem.setItem(item);   // Set the item reference
            cartItem.setQuantity(1);  // Set initial quantity to 1
        }
    
        // Save the cart item (either new or updated)
        cartItemRepo.save(cartItem);
    
        // Recalculate the total cost including the new item
        double total = cart.getCartItems().stream().mapToDouble(ci -> ci.getItem().getPrice() * ci.getQuantity()).sum();
        double tax = total * 0.16;  // Assuming 16% tax
        cart.setTotalCost(total + tax);
    
        // Save the updated cart with total cost
        cartRepo.save(cart);
    
        return "Item added to cart with updated quantity and total cost.";
    }
    

    @GetMapping("/totalCost/{cartId}")
    public double calculateTotalCost(@PathVariable long cartId) {
        Cart cart = cartRepo.findById(cartId).orElseThrow();
        double total = cart.getCartItems().stream().mapToDouble(ci -> ci.getItem().getPrice() * ci.getQuantity()).sum();
        double tax = total * 0.16;  // Assuming 16% tax
        cart.setTotalCost(total + tax);
        cartRepo.save(cart);
        return cart.getTotalCost();
    }
}
