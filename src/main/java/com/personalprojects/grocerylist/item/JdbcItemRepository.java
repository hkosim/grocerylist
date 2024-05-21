//package com.personalprojects.grocerylist.item;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.jdbc.core.simple.JdbcClient;
//import org.springframework.stereotype.Repository;
//import org.springframework.util.Assert;
//
//import java.util.List;
//import java.util.Optional;
//
//// Using JDBC Client to do CRUD
//@Repository
//
////public class JdbcItemRepository implements ItemRepository{
//public class JdbcItemRepository{
//
//    private static final Logger log = LoggerFactory.getLogger(JdbcItemRepository.class);
//    private final JdbcClient jdbcClient;
//
//    public JdbcItemRepository(JdbcClient jdbcClient) {
//        this.jdbcClient = jdbcClient;
//    }
//
//    public List<Item> findAll() {
//        return jdbcClient.sql("select * from run")
//                .query(Item.class)
//                .list();
//    }
//
//    public Optional<Item> findById(Integer id) {
//        return jdbcClient.sql("SELECT id, name, description, quantity, category, status, supermarket_name, purchased_on, version FROM Item WHERE id = :id" )
//                .param("id", id)
//                .query(Item.class)
//                .optional();
//    }
//
//    public void create(Item Item) {
//        var updated = jdbcClient.sql("INSERT INTO run(id, name, description, quantity, category, status, supermarket_name, purchased_on) values(?,?,?,?,?,?,?,?)")
//                .params (
//                        List.of(
//                            Item.id(),
//                            Item.name(),
//                            Item.description(),
//                            Item.quantity(),
//                            Item.category().toString(),
//                            Item.status().toString(),
//                            Item.supermarketName().toString(),
//                            Item.purchasedOn()
//                        )
//                )
//                .update();
//
//        Assert.state(updated == 1, "Failed to create Item " + Item.name());
//    }
//
//    public void update(Item Item, Integer id) {
//        var updated = jdbcClient.sql("update run set id=?, name=?, description=?, quantity=?, category=?, status=?, supermarket_name=?, purchased_on=?, version=?  where id = ?")
//                .params (
//                        List.of(
//                                Item.id(),
//                                Item.name(),
//                                Item.description(),
//                                Item.quantity(),
//                                Item.category().toString(),
//                                Item.status().toString(),
//                                Item.supermarketName().toString(),
//                                Item.purchasedOn(),
//                                Item.version(),
//                                id)
//                ).update();
//
//        Assert.state(updated == 1, "Failed to update Item " + Item.name());
//    }
//
//    public void delete(Integer id) {
//        var updated = jdbcClient.sql("delete from Item where id = :id")
//                .param("id", id)
//                .update();
//
//        Assert.state(updated == 1, "Failed to delete Item " + id);
//    }
//
//    public long count() {
//        return jdbcClient.sql("select * from Item").query().listOfRows().size();
//    }
//
//    public void saveAll(List<Item> Items) {
//        Items.stream().forEach(this::create);
//    }
//
////    public List<Item> findBySupermarketName(String location) {
////        return jdbcClient.sql("select * from Item where location = :location")
////                .param("location", location)
////                .query(Item.class)
////                .list();
////    }
//
//}