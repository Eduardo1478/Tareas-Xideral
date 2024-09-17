package com.example.shopping_cart_rest_api_jpa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "carts_items")
public class CartItem {

    @EmbeddedId
    private CartItemKey id = new CartItemKey();  // Composite key for CartItem

    @ManyToOne
    @MapsId("cartId")  // Mapping the composite key part
    @JoinColumn(name = "cart_id")
    @JsonBackReference  // To break the circular reference
    @Getter
    @Setter
    private Cart cart;

    @ManyToOne
    @MapsId("itemId")  // Mapping the composite key part
    @JoinColumn(name = "item_id")
    @Getter
    @Setter
    private Item item;

    @Column(nullable = false)
    @Getter
    @Setter
    private int quantity;  // Quantity of the item in the cart
}
