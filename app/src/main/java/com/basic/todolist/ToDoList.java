package com.basic.todolist;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "ToDoList_tb")
public class ToDoList {

    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo
    private String Title;

    @ColumnInfo
    private boolean status;

    public ToDoList(String title, boolean status) {
        Title = title;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ToDoList(String title) {
        Title = title;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public ToDoList() {
    }

    public ToDoList(int ID, String title) {
        this.ID = ID;
        Title = title;
    }
}
