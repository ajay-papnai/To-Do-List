package com.basic.todolist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ToDoViewModel  extends AndroidViewModel {

    private LiveData<List<ToDoList>> all_todolist;
    private final ToDoDAO toDoDAO;
    private ToDoDatabase toDoDatabase;
    private final ExecutorService executorService;

    private String editTextToDo = "";


    public ToDoViewModel(@NonNull Application application) {
        super(application);
        toDoDatabase = ToDoDatabase.getInstance(application);
        toDoDAO = toDoDatabase.toDoDAO();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<ToDoList>> getAll_todolist() {
        all_todolist = toDoDAO.get_todolist();
        return all_todolist;
    }

    public void add_todolist(ToDoList toDoList){
        executorService.execute(()->toDoDAO.insert(toDoList));
    }

    public void delete_todolist(ToDoList toDoList){
        executorService.execute(()->toDoDAO.delete(toDoList));
    }

    public void update_todolist(ToDoList toDoList){ executorService.execute(()->toDoDAO.Update(toDoList));}


    public String getEditTextToDo() {
        return editTextToDo;
    }

    public void setEditTextToDo(String editTextToDo) {
        this.editTextToDo = editTextToDo;
    }
}
