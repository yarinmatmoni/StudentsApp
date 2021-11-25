package com.example.studentsapp.model;

public class Student {
    String name = "";
    String id = "";
    boolean check = false;

    public Student (){}

    public Student(String name, String id, boolean check) {
        this.name = name;
        this.id = id;
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
