package com.example.shopping_cart_rest_api_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopping_cart_rest_api_jpa.models.CartItem;
import com.example.shopping_cart_rest_api_jpa.models.CartItemKey;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemKey> {
}
