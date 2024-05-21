package com.personalprojects.grocerylist.item;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ItemJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ItemJsonDataLoader.class);
    private final ObjectMapper objectMapper;
    private final ItemRepository itemRepository;

    public ItemJsonDataLoader(ObjectMapper objectMapper, ItemRepository itemRepository) {
        this.objectMapper = objectMapper;
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(itemRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/items.json")) {
                Items allItems = objectMapper.readValue(inputStream, Items.class);
                log.info("Reading {} items from JSON data and saving to database.", allItems.items().size());
                itemRepository.saveAll(allItems.items());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Not loading Items from JSON data because the collection contains data.");
        }
    }

}