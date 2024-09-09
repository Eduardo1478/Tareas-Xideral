package com.example.shopping_cart_rest_api_jpa.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//Setting the getters and setters using lombok
@Entity
@Table(name = "shopping_list")
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

}
