package com.example.shopping_cart_rest_api_jpa.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shopping_list")
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter 
    private long id;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private double price;

    @Column
    @Getter
    @Setter
    private LocalDate expiryDate;

    @Column
    @Getter
    @Setter
    private String section;

    @Column
    @Getter
    @Setter
    private double weight;

    public Item(long id, String name, double price, LocalDate expiryDate, String section, double weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
        this.section = section;
        this.weight = weight;
    }

}
