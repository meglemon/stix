package com.techelevator.dao;

import com.techelevator.model.Items;
import com.techelevator.model.Lists;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class JdbcItemsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcItemsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // create item
    public Items addItemsToList(Items item) {

        String sql = "INSERT INTO items (item_name, list_id) " +
                "VALUES (?, ?);";

        int itemId = jdbcTemplate.queryForObject(sql, Integer.class, item.getItem_name(), item.getList_id());
        item.setItem_id(itemId);

        return item;
    }

    // get items
    // update items
    // delete items
}
