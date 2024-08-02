package com.basic.todolist;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.basic.todolist.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private ToDoViewModel toDoViewModel;

    private ArrayList<ToDoList> toDoListArrayList = new ArrayList<>();
    private ToDoDatabase toDoDatabase;

    private ToDoAdapter toDoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main);

        RecyclerView recyclerView = activityMainBinding.recycler;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        toDoDatabase = ToDoDatabase.getInstance(this);

        toDoViewModel = new ViewModelProvider(this).get(ToDoViewModel.class);

        //ToDoList t1 = new ToDoList( "hiiiiiiiiiiii");
        //toDoViewModel.add_todolist(t1);

        toDoViewModel.getAll_todolist().observe(this, new Observer<List<ToDoList>>() {
            @Override
            public void onChanged(List<ToDoList> toDoLists) {
                    toDoListArrayList.clear();

                    toDoListArrayList.addAll(toDoLists);
                    toDoAdapter.notifyDataSetChanged();
            }
        });

        toDoAdapter = new ToDoAdapter(toDoListArrayList , toDoViewModel);
        recyclerView.setAdapter(toDoAdapter);

        activityMainBinding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add_todo addTodo = new Add_todo();
                addTodo.show(getSupportFragmentManager() , addTodo.getTag());
            }
        });


    }
}