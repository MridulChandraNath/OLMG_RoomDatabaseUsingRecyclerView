package com.example.roomdatabaseusingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements StudentListFragment.AddforListener, AddStudentForm.ListOfStudentListener {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        StudentListFragment studentListFragment=new StudentListFragment();
        fragmentTransaction.add(R.id.fragmentContainer,studentListFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void studentAddFormIsFound() {

        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();

        AddStudentForm addStudentForm=new AddStudentForm();

        fragmentTransaction.add(R.id.fragmentContainer,addStudentForm);
        fragmentTransaction.commit();


    }

    @Override
    public void studentAdded(String name) {
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        Bundle bundle=new Bundle();
        bundle.putString("name",name);
        StudentListFragment studentListFragment=new StudentListFragment();
        studentListFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragmentContainer,studentListFragment);
        fragmentTransaction.commit();

    }
}
