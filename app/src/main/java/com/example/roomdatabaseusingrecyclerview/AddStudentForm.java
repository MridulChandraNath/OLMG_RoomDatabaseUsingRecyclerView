package com.example.roomdatabaseusingrecyclerview;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdatabaseusingrecyclerview.entities.Student;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddStudentForm extends Fragment {
    EditText nameET,ageET,departmentET;
    Button addBtn;
    Context context;
    ListOfStudentListener listOfStudentListener;


    public AddStudentForm() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        listOfStudentListener= (ListOfStudentListener) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_student_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nameET=view.findViewById(R.id.nameET);
        ageET=view.findViewById(R.id.ageET);
        departmentET=view.findViewById(R.id.departmentET);

        addBtn=view.findViewById(R.id.addBtn);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameET.getText().toString();
                String age=ageET.getText().toString();
                String department=departmentET.getText().toString();
                if(TextUtils.isEmpty(name)) {
                    nameET.setError("Name is required!");
                    return;

                }
                else if(TextUtils.isEmpty(age)) {

                    /**
                     *   You can Toast a message here that the Username is Empty
                     **/

                    ageET.setError("Age is required!");
                    return;

                }

                else if (TextUtils.isEmpty(department)){
                    departmentET.setError("Department is required!");
                    return;
                }
                    Student student=new Student(name,age,department);
                //saving to database
                long insertedRow=StudentDatabase.getInstance(context).getStudentDao().insertStudent(student);
                //Mind it that if data added you will get number which is greater than 0.

                listOfStudentListener.studentAdded(name);




            }
        });

    }

    interface ListOfStudentListener{
        void studentAdded(String name);
    }
}
