package com.techelevator.model;

public class Items {

    //  FIELDS  //
    String item_name;
    int item_id;
    int list_id;


    //  CONSTRUCTORS    //
    public Items(String item_name, int item_id, int list_id) {
        this.item_name = item_name;
        this.item_id = item_id;
        this.list_id = list_id;
    }

    public Items(){};


    //  GETTERS & SETTERS   //
    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }
}
