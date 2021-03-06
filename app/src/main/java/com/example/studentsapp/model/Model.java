package com.example.studentsapp.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model(){
        for (int i=0 ; i<4 ;i++){
            Student s = new Student("name"+i , "id_"+i ,"054-"+i ,"add_"+i , false);
            data.add(s);
        }
    }

    List<Student> data =new LinkedList<Student>();

    public List<Student> getAllStudents(){
        return data;
    }
    public Student getStudent(int index){ //eden!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        return data.get(index);
    }
    public void deleteStudent(int index){//eden!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        data.remove(index);
    }
    public void addStudent(String name, String id,String phone,String address, boolean check){
        Student s = new Student(name,id,phone,address,check);
        data.add(s);
    }
}
