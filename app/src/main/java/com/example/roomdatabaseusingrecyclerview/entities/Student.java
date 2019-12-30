package com.example.roomdatabaseusingrecyclerview.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "col_Name")
    private String name;
    @ColumnInfo(name = "col_age")
    private String age;
    @ColumnInfo(name = "Col_department")
    private String department;
    @Ignore
    private int count;

    @Ignore
    public Student(int id, String name, String age, String department) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public Student(String name, String age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
