package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.SqlValue;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Lists;
import com.techelevator.model.User;

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

    private Lists mapRowToList(SqlRowSet results) {
        Lists list = new Lists();
        list.setListName(results.getString("list_name"));
        list.setListId(results.getInt("list_id"));
        list.setUserId(results.getInt("user_id"));
        return list;
    }

}