package com.example.shopping_cart_rest_api_jpa.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.shopping_cart_rest_api_jpa.models.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository // Marks this class as a repository bean for Spring's component scanning
@Transactional // Ensures that all database operations are transactional (commit or rollback)
public class ItemRepository {

    @PersistenceContext // Injects the EntityManager to interact with the database
    private EntityManager entityManager;

    // Method to save a single item to the database
    public void save(Item item){
        entityManager.persist(item);
    }

    // Method to save a list of items to the database
    public void saveAll(List<Item> items) {
        // Loops through the list of items and persists each one to the database
        for (Item item : items) {
            entityManager.persist(item); 
        }
    }

    // Method to update an existing item in the database
    public void update(Item item) {
        entityManager.merge(item); 
    }

    // Method to find an item by its id (primary key)
    public Item findById(long id) {
        return entityManager.find(Item.class, id); 
    }

    // Method to retrieve all items from the database
    public List<Item> findAll() {
        // Executes a JPQL query to fetch all items
        return entityManager.createQuery("from Item", Item.class).getResultList(); 
    }

    // Method to delete an existing item from the database
    public void delete(Item item) {
        entityManager.remove(item); 
    }
}
