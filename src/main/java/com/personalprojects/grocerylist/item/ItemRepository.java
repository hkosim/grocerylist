package com.personalprojects.grocerylist.item;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ItemRepository extends ListCrudRepository<Item, Integer> {

//    List<Item> findAll();
//
//    Optional<Item> findById(Integer id);
//
//    void create(Item Item);
//
//    void update(Item Item, Integer id);
//
//    void delete(Integer id);
//
//    int count();
//
//    void saveAll(List<Item> Items);

    List<Item> findBySupermarketName(String location);
}
