package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    //  FIELDS  //
    private String listName;
    private List<String> list = new ArrayList<>();
    private int listId;
    private int userId;


    //  CONSTRUCTOR //
    public Lists(String listName) {
        this.listName = listName;
        this.listId = listId;
        this.userId = userId;
    }

    public Lists(){};


    //  GETTERS & SETTERS   //
    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //  FUNCTIONS   //
    public void addItem(String item){
        list.add(item);
    }

    public void removeItem(String item){
        list.remove(item);
    }



}
