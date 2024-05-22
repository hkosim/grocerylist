package com.personalprojects.grocerylist.item;

import com.personalprojects.grocerylist.item.enums.Category;
import com.personalprojects.grocerylist.item.enums.ItemStatus;
import com.personalprojects.grocerylist.item.enums.SupermarketName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryItemRepositoryTest {

    InMemoryItemRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryItemRepository();
        repository.create(
                new Item(1,
                        "Apple",
                        "This is a testing apple.",
                        10,
                        Category.FOOD,
                        ItemStatus.NOT_BOUGHT,
                        SupermarketName.REWE,
                        LocalDateTime.now(),
                        0)
        );

        repository.create(
                new Item(2,
                        "Orange",
                        "This is a testing orange.",
                        8,
                        Category.FOOD,
                        ItemStatus.NOT_BOUGHT,
                        SupermarketName.REWE,
                        LocalDateTime.now(),
                        0)
        );

        repository.create(
                new Item(3,
                        "Detergent",
                        "This is a testing soap.",
                        8,
                        Category.HYGIENE,
                        ItemStatus.BOUGHT,
                        SupermarketName.LIDL,
                        LocalDateTime.now(),
                        0)
        );
    }

    @Test
    void shouldFindAllItems(){
        List<Item> items = repository.findAll();
        assertEquals(3, items.size(), "Should have returned 3 items.");
    }

    @Test
    void shouldFindItemWithValidId(){
        var items = repository.findById(2).get();
        assertEquals("Orange", items.name());
        assertEquals(SupermarketName.REWE, items.supermarketName());
    }

    @Test
    void shouldCreateNewItem(){
        repository.create(
                new Item(4,
                        "Hammer",
                        "BAM!",
                        2,
                        Category.TOOL,
                        ItemStatus.BOUGHT,
                        SupermarketName.ALDI,
                        LocalDateTime.now(),
                        0)
        );

        List<Item> items = repository.findAll();
        assertEquals(4, items.size(), "Should have returned 3 items.");
    }
}