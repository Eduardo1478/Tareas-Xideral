package com.example.shopping_cart_rest_api_jpa.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.shopping_cart_rest_api_jpa.models.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class ItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Item item){
        entityManager.persist(item);
    }

    public void saveAll(List<Item> items) {
        for (Item item : items) {
            entityManager.persist(item);
        }
    }

    public void update(Item item) {
        entityManager.merge(item); 
    }

    public Item findById(long id) {
        return entityManager.find(Item.class, id);
    }

    public List<Item> findAll() {
        return entityManager.createQuery("from Item", Item.class).getResultList(); 
    }

    public void delete(Item item) {
        entityManager.remove(item); 
    }

}
