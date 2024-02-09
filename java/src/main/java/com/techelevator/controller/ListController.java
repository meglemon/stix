package com.techelevator.controller;

import com.techelevator.dao.ListsDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ListController {

    private final ListsDao listsDao;

    public ListController(ListsDao listsDao) {
        this.listsDao = listsDao;
    }

    // get list names
    @GetMapping("/lists/{userId}")
    public List<String> getListNamesByUserId (@PathVariable int userId){
        return listsDao.getListsByUserId(userId);
    }


    // add item from list
    // remove item from list

}
