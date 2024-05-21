package com.personalprojects.grocerylist.item;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
class ItemController {

    private final ItemRepository itemRepository;

    ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("")
    List<Item> findAll() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    Item findById(@PathVariable Integer id) {
        Optional<Item> item = itemRepository.findById(id);
        if(item.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found.");
        }
        return item.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Item item) {
        itemRepository.save(item);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid
                @RequestBody Item item,
                @PathVariable Integer id) {
        Optional<Item> itemInDb = itemRepository.findById(id);

        if(itemInDb.isPresent()) {
            Item newItem = new Item(
                    itemInDb.get().id(),
                    item.name(),
                    item.description(),
                    item.quantity(),
                    item.category(),
                    item.status(),
                    item.supermarketName(),
                    item.purchasedOn(),
                    itemInDb.get().version()
            );

            itemRepository.save(newItem);
        }


    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        itemRepository.delete(itemRepository.findById(id).get());
    }
    @GetMapping("/supermarket/{supermarketName}")
    List<Item> findBySupermarketName(@PathVariable String supermarketName) {
        return itemRepository.findBySupermarketName(supermarketName);
    }
}