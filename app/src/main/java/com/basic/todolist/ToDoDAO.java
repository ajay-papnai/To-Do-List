package com.basic.todolist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface ToDoDAO {

    @Insert
    void insert(ToDoList toDoList);

    @Delete
    void delete(ToDoList toDoList);

    @Query("select * from ToDoList_tb")
    LiveData<List<ToDoList>> get_todolist();

    @Update
    void Update(ToDoList toDoList);
}
