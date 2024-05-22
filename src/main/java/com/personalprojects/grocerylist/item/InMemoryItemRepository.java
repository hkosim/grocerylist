package com.personalprojects.grocerylist.item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
class InMemoryItemRepository {

    private static final Logger log = LoggerFactory.getLogger(InMemoryItemRepository.class);
    private final List<Item> items = new ArrayList<>();

    public List<Item> findAll() {
        return items;
    }

    public Optional<Item> findById(Integer id) {
        return Optional.ofNullable(items.stream()
                .filter(item -> item.id() == id)
                .findFirst()
                .orElseThrow(ItemNotFoundException::new));
    }

    public void create(Item item) {
        Item newItem = new Item(
                item.id(),
                item.name(),
                item.description(),
                item.quantity(),
                item.category(),
                item.status(),
                item.supermarketName(),
                item.purchasedOn(),
                null
        );

        items.add(newItem);
    }

    public void update(Item newItem, Integer id) {
        Optional<Item> existingItem = findById(id);
        if(existingItem.isPresent()) {
            var r = existingItem.get();
            log.info("Updating Existing Item: " + existingItem.get());
            items.set(items.indexOf(r), newItem);
        }
    }

    public void delete(Integer id) {
        log.info("Deleting Item: " + id);
        items.removeIf(item -> item.id().equals(id));
    }

    public int count() {
        return items.size();
    }

    public void saveAll(List<Item> items) {
        items.stream().forEach(item -> create(item));
    }

    public List<Item> findBySupermarketName(String supermarketName) {
        return items.stream()
                .filter(item -> Objects.equals(item.supermarketName(), supermarketName))
                .toList();
    }


}
