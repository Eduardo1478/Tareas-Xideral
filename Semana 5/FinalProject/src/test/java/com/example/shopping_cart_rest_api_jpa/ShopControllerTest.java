package com.example.shopping_cart_rest_api_jpa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.shopping_cart_rest_api_jpa.controllers.ShopController;
import com.example.shopping_cart_rest_api_jpa.models.Item;
import com.example.shopping_cart_rest_api_jpa.repository.ItemRepository;
import com.example.shopping_cart_rest_api_jpa.services.CartNotificationService;


@SpringBootTest
public class ShopControllerTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private CartNotificationService cartNotificationService;

    @InjectMocks
    private ShopController shopController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testIndex() {
        String response = shopController.index();
        assertEquals("Shop Connected", response);
    }

    @Test
    public void testGetItems() {
        // Mocking the repository response
        Item item1 = new Item();
        item1.setName("Apple");
        Item item2 = new Item();
        item2.setName("Banana");

        List<Item> itemList = Arrays.asList(item1, item2);
        when(itemRepository.findAll()).thenReturn(itemList);

        // Call the controller method
        List<Item> result = shopController.getItems();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("Apple", result.get(0).getName());
    }

    @Test
    public void testSaveItem() {
        // Mock item to save
        Item item = new Item();
        item.setName("Orange");

        // Call the controller method
        String response = shopController.save(item);

        // Verify that the itemRepository and cartNotificationService were called
        verify(itemRepository).save(item);
        verify(cartNotificationService).sendCartNotification("New item added: Orange");

        // Assert the response
        assertEquals("Saved item and sent notification", response);
    }

    @Test
    public void testUpdateItem() {
        // Mock the existing item
        Item existingItem = new Item();
        existingItem.setId(1L);
        existingItem.setName("Apple");
        existingItem.setPrice(1.0);
        when(itemRepository.findById(1L)).thenReturn(Optional.of(existingItem));

        // New data for update
        Item updatedItem = new Item();
        updatedItem.setName("Updated Apple");
        updatedItem.setPrice(2.0);

        // Call the controller method
        String response = shopController.update(1L, updatedItem);

        // Verify that the item was updated
        verify(itemRepository).save(existingItem);

        // Assert the response
        assertEquals("edited", response);
    }

    @Test
    public void testDeleteItem() {
        // Mock the existing item
        Item item = new Item();
        item.setId(1L);
        item.setName("Apple");

        when(itemRepository.findById(1L)).thenReturn(Optional.of(item));

        // Call the controller method
        String response = shopController.delete(1L);

        // Verify that the itemRepository was called
        verify(itemRepository).delete(item);

        // Assert the response
        assertEquals("deleted", response);
    }
}
