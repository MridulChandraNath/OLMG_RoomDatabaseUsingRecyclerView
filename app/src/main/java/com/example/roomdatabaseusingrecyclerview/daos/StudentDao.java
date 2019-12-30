package com.example.roomdatabaseusingrecyclerview.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabaseusingrecyclerview.entities.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    long insertStudent(Student student);
    @Insert
    long[] insetMultipleStudents(Student... students);
    @Update
    int updateStudent(Student student);
    @Delete
    int deleteStudent(Student student);

    @Query("select * from student_table")
    List<Student>getAllStudent();

    @Query("select * from student_table where id like:id")
    Student getStudentById(long id);





}
