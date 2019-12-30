package com.example.roomdatabaseusingrecyclerview;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.roomdatabaseusingrecyclerview.entities.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentListFragment extends Fragment {
    RecyclerView studentRV;
    FloatingActionButton floatingActionButton;
    Context context;
    AddforListener addforListener;



    public StudentListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        addforListener= (AddforListener) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle=getArguments();
       if (bundle != null){
           String name=bundle.getString("name");
           Toast.makeText(context, "Welcome "+name, Toast.LENGTH_SHORT).show();
       }
        List<Student> studentList=StudentDatabase.getInstance(context)
                .getStudentDao().getAllStudent() ;
        Toast.makeText(context, "Total student: "+studentList.size(), Toast.LENGTH_SHORT).show();
        studentRV=view.findViewById(R.id.studentRV);
        floatingActionButton=view.findViewById(R.id.floatingActionButton);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               addforListener.studentAddFormIsFound();
            }
        });

    }

    interface AddforListener{
        void studentAddFormIsFound();
    }
}
