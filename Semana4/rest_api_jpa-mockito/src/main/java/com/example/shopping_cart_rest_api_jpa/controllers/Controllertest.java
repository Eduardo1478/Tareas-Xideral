package com.example.shopping_cart_rest_api_jpa.controllers;

import com.example.shopping_cart_rest_api_jpa.models.Item;
import com.example.shopping_cart_rest_api_jpa.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class Controllertest {

    private MockMvc mockMvc;

    @Mock
    private ItemRepository repository;

    @InjectMocks
    private Controller controller;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetItems() throws Exception{
        List<Item> mockItems = Arrays.asList(
                new Item(1L, "Item1", 100.0, "Section1", 1.5, "2024-01-01"),
                new Item(2L, "Item2", 150.0, "Section2", 2.0, "2024-02-01")
        );
        when(repository.findAll()).thenReturn(mockItems);

        mockMvc.perform(get("/items"))
            .contentType(MediaType.APPLICATION_JSON)
            .andExpect(status().isOk());
        
        verify(repository, times(1)).findAll();
    }
}
