package com.basic.todolist;

import static androidx.databinding.DataBindingUtil.setContentView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.basic.todolist.databinding.ActivityAddTodoBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class Add_todo extends BottomSheetDialogFragment{

    private ActivityAddTodoBinding addTodoBinding;
    private ToDoViewModel toDoViewModel;
    private ToDoList toDoList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState ){
        addTodoBinding = DataBindingUtil.inflate(inflater , R.layout.activity_add_todo , container , false);


        toDoViewModel = new ViewModelProvider(requireActivity()).get(ToDoViewModel.class);

        addTodoBinding.editTodo.setText(toDoViewModel.getEditTextToDo());

        addTodoBinding.editTodo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    toDoViewModel.setEditTextToDo(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        addTodoBinding.Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toDoViewModel.getEditTextToDo().toString().isEmpty()){
                    Toast.makeText(getContext(), "Enter task", Toast.LENGTH_SHORT).show();
                }
                else{
                    toDoList = new ToDoList(toDoViewModel.getEditTextToDo().toString());
                    toDoViewModel.add_todolist(toDoList);
                    toDoViewModel.setEditTextToDo("");
                    dismiss();
                }
            }
        });

        addTodoBinding.Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return addTodoBinding.getRoot();

    }
}