package com.example.shopping_cart_rest_api_jpa.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
public class CartItemKey implements Serializable {

    @Column(name = "cart_id")
    @Getter
    @Setter
    private Long cartId;

    @Column(name = "item_id")
    @Getter
    @Setter
    private Long itemId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemKey that = (CartItemKey) o;
        return Objects.equals(cartId, that.cartId) && Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, itemId);
    }
}
