package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simpleJpaUnit");
        EntityManager em = emf.createEntityManager();
        
        // Create a new user
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        

        // Save the user to the database
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(user);
            transaction.commit();
            System.out.println("User saved with ID: " + user.getId());
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
