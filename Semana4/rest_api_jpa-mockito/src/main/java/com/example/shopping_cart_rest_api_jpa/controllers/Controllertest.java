package com.example.shopping_cart_rest_api_jpa.controllers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.shopping_cart_rest_api_jpa.models.Item;
import com.example.shopping_cart_rest_api_jpa.repository.ItemRepository;

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
            new Item(1L, "Item1", 100.0, LocalDate.of(2024, 1, 1), "Section1", 1.5),
            new Item(2L, "Item2", 150.0, LocalDate.of(2024, 2, 1), "Section2", 2.0)
        );
        when(repository.findAll()).thenReturn(mockItems);

        mockMvc.perform(MockMvcRequestBuilders.get("/items")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        
        verify(repository, times(1)).findAll();
    }
}
