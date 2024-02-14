package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    //  FIELDS  //
    private String list_name;
    private List<String> list = new ArrayList<>();
    private int listId;
    private int user_id;


    //  CONSTRUCTOR //
    public Lists(String list_name) {
        this.list_name = list_name;
        this.listId = listId;
        this.user_id = user_id;
        this.list = list;
    }

    public Lists(){};


    //  GETTERS & SETTERS   //
    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    //  FUNCTIONS   //
    public void addItem(String item){
        list.add(item);
    }

    public void removeItem(String item){
        list.remove(item);
    }

    @Override
    public String toString() {
        return "Lists{" +
                "list_name='" + list_name + '\'' +
                ", list=" + list +
                ", listId=" + listId +
                ", userId=" + user_id +
                '}';
    }
}
