package com.techelevator.controller;

import com.techelevator.dao.ListsDao;
import com.techelevator.model.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    // create new list
    @PostMapping("/lists")
    @ResponseStatus(HttpStatus.CREATED)
    public Lists createNewList(@RequestBody Lists newList) {
        return listsDao.createNewList(newList);
    }


}
