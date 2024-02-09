package com.techelevator.dao;

import com.techelevator.model.Lists;

import java.util.List;

public interface ListsDao {

    List<String> getListsByUserId(int userId);

}