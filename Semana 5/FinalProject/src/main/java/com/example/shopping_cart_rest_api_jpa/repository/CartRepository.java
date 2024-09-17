package com.example.shopping_cart_rest_api_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopping_cart_rest_api_jpa.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
