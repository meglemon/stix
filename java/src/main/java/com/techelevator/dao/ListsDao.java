package com.techelevator.dao;

import com.techelevator.model.Items;
import com.techelevator.model.Lists;

import java.util.List;

public interface ListsDao {

    List<String> getListsByUserId(int userId);

    Lists createNewList(Lists newList);

    void deleteList(Lists listToDelete);

    Items addItemsToList(Items item);

    void deleteItem(Items itemToDelete);
}