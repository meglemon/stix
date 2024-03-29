package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Items;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Lists;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcListsDao implements ListsDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcListsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getListsByUserId(int userId){
        List<String> listNames = new ArrayList<>();
        String name;

        String sql = "SELECT list_id, list_name FROM lists " +
                "WHERE user_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

            while(results.next()){
                name = results.getString("list_name");
                listNames.add(name);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }

        return listNames;
    }

    public Lists createNewList(Lists newList){
        String sql = "INSERT INTO lists (list_name, user_id) " +
                "VALUES (?, ?) " +
                "RETURNING list_id;";

        int listId = jdbcTemplate.queryForObject(sql, Integer.class, newList.getList_name(), newList.getUser_id());
        newList.setListId(listId);

        return newList;
    }

    // delete list
    public void deleteList(Lists listToDelete){
        int id = listToDelete.getListId();

        String sql = "DELETE FROM lists " +
                "WHERE list_id = ?";

        String sql2 = "DELETE FROM items " +
                "WHERE list_id = ?";

        jdbcTemplate.execute(sql);
        jdbcTemplate.execute(sql2);
    }


    // create item
    public Items addItemsToList(Items item) {
        String sql = "INSERT INTO items (item_name, list_id) " +
                "VALUES (?, ?) " +
                "RETURNING item_id;";

        int itemId = jdbcTemplate.queryForObject(sql, Integer.class, item.getItem_name(), item.getList_id());
        item.setItem_id(itemId);

        return item;
    }

    public void deleteItem(Items itemToDelete){
       int id = itemToDelete.getItem_id();

        String sql = "DELETE FROM items " +
                "WHERE item_id = " + id;

        jdbcTemplate.execute(sql);
    }


    // helper methods
    private Lists mapRowToList(SqlRowSet results) {
        Lists list = new Lists();
        list.setList_name(results.getString("list_name"));
        list.setListId(results.getInt("list_id"));
        list.setUser_id(results.getInt("user_id"));
        return list;
    }

}