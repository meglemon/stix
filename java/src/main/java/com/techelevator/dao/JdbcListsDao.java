package com.techelevator.dao;

import com.techelevator.exception.DaoException;
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

    //add items to list
//      for (String item : newList.)
//    String sqlAddItems = "INSERT INTO items (item_name, list_id) " +
//            "VALUES (?," + listId + ");";



    private Lists mapRowToList(SqlRowSet results) {
        Lists list = new Lists();
        list.setList_name(results.getString("list_name"));
        list.setListId(results.getInt("list_id"));
        list.setUser_id(results.getInt("user_id"));
        return list;
    }

}