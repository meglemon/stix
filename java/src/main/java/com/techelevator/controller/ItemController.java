//package com.techelevator.controller;
//
//
//import com.techelevator.dao.ItemsDao;
//import com.techelevator.model.Items;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@CrossOrigin
//public class ItemController {
//
//    private final ItemsDao itemsDao;
//
//    public ItemController(ItemsDao itemsDao) {
//        this.itemsDao = itemsDao;
//    }
//
//    @PostMapping("/items/")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Items addItems(@RequestBody Items item){
//        return itemsDao.addItemsToList(item);
//    }
//
//
//}
