package com.basic.todolist;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ToDoList.class}, version = 3)
public abstract class ToDoDatabase extends RoomDatabase {

    private static final String Database_name = "ToDoList_db";
    private static ToDoDatabase instance;
    public abstract ToDoDAO toDoDAO();

    public static synchronized ToDoDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext() , ToDoDatabase.class , Database_name).fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
