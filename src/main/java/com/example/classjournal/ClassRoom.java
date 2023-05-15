package com.example.classjournal;

import android.text.Editable;

public class ClassRoom
{
    String classname;
    int number_of_students;
    public ClassRoom(String classname, int number_of_students)
    {
        this.classname=classname;
        this.number_of_students=number_of_students;

    }

    public ClassRoom(Editable text) {
    }

    public String getClassname() {
        return this.classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getNumber_of_students() {
        return number_of_students;
    }

    public void setNumber_of_students(int number_of_students) {
        this.number_of_students = number_of_students;
    }
}
