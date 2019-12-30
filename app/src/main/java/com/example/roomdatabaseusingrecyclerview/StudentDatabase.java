package com.example.roomdatabaseusingrecyclerview;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabaseusingrecyclerview.daos.StudentDao;
import com.example.roomdatabaseusingrecyclerview.entities.Student;

@Database(entities = {Student.class},version = 1)
public abstract class StudentDatabase extends RoomDatabase {
    private static StudentDatabase db;
    public abstract StudentDao getStudentDao();

    public static StudentDatabase getInstance(Context context){
            if (db!=null){

                return db;
            }
            db=Room.databaseBuilder(context, StudentDatabase.class,"student_db").allowMainThreadQueries().build();
            return db;

    }

}
