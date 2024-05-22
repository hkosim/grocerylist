package com.personalprojects.grocerylist.item;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalprojects.grocerylist.item.enums.Category;
import com.personalprojects.grocerylist.item.enums.ItemStatus;
import com.personalprojects.grocerylist.item.enums.SupermarketName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ItemRepository repository;

    private final List<Item> items = new ArrayList<>();

    @BeforeEach
    void setUp() {
        items.add(
                new Item(1,
                        "Apple",
                        "This is a testing apple.",
                        10,
                        Category.FOOD,
                        ItemStatus.NOT_BOUGHT,
                        SupermarketName.REWE,
                        LocalDateTime.now(),
                        null)
        );

        items.add(
                new Item(2,
                        "Orange",
                        "This is a testing orange.",
                        8,
                        Category.FOOD,
                        ItemStatus.NOT_BOUGHT,
                        SupermarketName.REWE,
                        LocalDateTime.now(),
                        null)
        );

        items.add(
                new Item(3,
                        "Detergent",
                        "This is a testing soap.",
                        8,
                        Category.HYGIENE,
                        ItemStatus.BOUGHT,
                        SupermarketName.LIDL,
                        LocalDateTime.now(),
                        null)
        );


    }

    @Test
    void shouldFindAllItems() throws Exception {
        when(repository.findAll()).thenReturn(items);
        mvc.perform(get("/api/runs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(items.size())));
    }

}