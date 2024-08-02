package com.basic.todolist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.basic.todolist.databinding.RecyclerViewBinding;

import java.util.ArrayList;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.TodoViewHolder> {

    private ArrayList<ToDoList> toDoListArrayList;
    private ToDoViewModel toDoViewModel;

    public ToDoAdapter(ArrayList<ToDoList> toDoListArrayList, ToDoViewModel toDoViewModel) {
        this.toDoListArrayList = toDoListArrayList;
        this.toDoViewModel = toDoViewModel;
    }


    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        RecyclerViewBinding recyclerViewBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.recycler_view, viewGroup , false);



        return new TodoViewHolder(recyclerViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder todoViewHolder, int i) {

        ToDoList toDoList = toDoListArrayList.get(i);
        todoViewHolder.recyclerViewBinding.setTodolist(toDoList);
        todoViewHolder.recyclerViewBinding.checkBox.setChecked((toDoList.isStatus()));



        todoViewHolder.recyclerViewBinding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                toDoList.setStatus(b);
                toDoViewModel.update_todolist(toDoList);
            }
        });


        todoViewHolder.recyclerViewBinding.cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(todoViewHolder.itemView.getContext(), ""+(todoViewHolder.recyclerViewBinding.checkBox).isChecked(), Toast.LENGTH_SHORT).show();
                toDoViewModel.delete_todolist(toDoList);
            }
        });
    }

    @Override
    public int getItemCount() {
        return toDoListArrayList.size();
    }


    class TodoViewHolder extends RecyclerView.ViewHolder{
        private RecyclerViewBinding recyclerViewBinding;


        public TodoViewHolder(RecyclerViewBinding recyclerViewBinding) {
            super(recyclerViewBinding.getRoot());
            this.recyclerViewBinding = recyclerViewBinding;
        }
    }
}
